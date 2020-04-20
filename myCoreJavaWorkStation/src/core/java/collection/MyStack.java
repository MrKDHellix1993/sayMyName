package core.java.collection;

import java.util.Arrays;

class MyStack {
	private Integer[] stackList;
	private int top;
	private int capacity;

	public MyStack(int size) {
		this.top = -1;
		this.capacity = size;
		this.stackList = new Integer[size];
	}

	public void push(Integer entry)  throws MyStackException {
		if(isFull())
		{
			throw new MyStackException("Stack full Exception");
//			System.out.println(" Stack is full");
		}else {
			stackList[++top] = entry;
		}
	}

	public Integer pop() {
		if(isEmpty())
		{
			System.out.println(" Stack is empty");
			return -1;
		}else {
			Integer popEle = stackList[top];
			stackList[top] = null;
			top--;
			return popEle;
		}
	}
	
	public boolean isEmpty()
	{
		boolean flag = (top == -1) ? true: false;
		return flag;
	}
	
	@Override
	public String toString() {
		return "MyStack [stackList=" + Arrays.toString(stackList) + ", top=" + top + ", capacity=" + capacity + "]";
	}

	public boolean isFull()
	{
		boolean flag = (top == capacity-1) ? true: false;
		return flag;
	}
}

class MyStackTest{
	
	public static void main(String[] args)  throws MyStackException {
		
		MyStack stack = new MyStack(5);
		System.err.println("stack.isEmpty() " + stack.isEmpty());
		stack.push(5);
		stack.push(3);
		stack.push(4);
		System.err.println("my stack " + stack);
		System.err.println("----------------- stack pop-----------");
		System.err.println("pop 1 " + stack.pop());
		System.err.println("pop 2 " + stack.pop());
		System.err.println("pop 3 " + stack.pop());
		System.err.println("pop 4 " + stack.pop());
		
		for(int i=0; i< 15; i++ )
		{
			stack.push(i);
		}
		System.err.println("my stack " + stack);
	}
}

class MyStackException extends Exception{
	
	public MyStackException(String s) 
    { 
        // Call constructor of parent Exception 
        super(s); 
    } 
}