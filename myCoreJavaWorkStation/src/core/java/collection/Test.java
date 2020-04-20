package core.java.collection;

import java.util.ArrayList;
import java.util.List;

class Test {
	static List<String> foo = new ArrayList<String>();
	String myValue;

	public Test(String val, List<String> newList) {
		foo = newList; // Modification-1
		this.myValue = val;
	}

	public void setFoo(List foo) {
		// this.foo = foo;// Results in compile time error.
	}

	public static void main(String[] args) {
    	 List<String> foo = new ArrayList<String>();
    	 foo.add("FD");
		Test t =new Test("Kd", foo);
		System.out.println("valuv" + t.myValue + " foo " + t.foo);
		foo.add("SB");
		Test t1 =new Test("SRD", foo);
		System.out.println("valuv 2 " + t1.myValue + " foo " + t1.foo);
		System.out.println("valuv" + t.myValue + " t foo  value " + t.foo);
	}
}
