package testDemo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserInput {
    
    public static class TextInput {
	String textInput = "";
	public void add(char c) {
		textInput += c;
	}

	public String getValue() {
		return this.textInput;
	}
}
    
    public static class NumericInput extends TextInput {
	public void add(char c) {
		if (Character.isDigit(c)) {
			textInput += c;
		}
	}
	
	public String getValue() {
		return this.textInput;
	}
}


	public static void main(String[] args) {
		 TextInput input = new NumericInput();
		 input.add('1');
		 input.add('a');
		 input.add('0');
//		 Integer [] a = new Integer[10];
		 List<Integer> aint =new ArrayList<Integer>();
		 aint.add(new Integer(5));
		 aint.add(new Integer(1));
		 aint.add(new Integer(2));
		 for(int az : aint)
		 {
			 if(az %2 == 0) {
				 break;
			 }
		 }
		 aint.forEach(aLambda ->{ 
			 if(aLambda %2 == 0)
				System.out.println(aLambda);
					 });
		 System.out.println(input.getValue());
	}
}
