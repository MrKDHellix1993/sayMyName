package excercse;

class Plant {

	public int vData = 100;
//	ConstructorDemo demo = new ConstructorDemo(10);
	protected Plant(int x) {
		vData = x;
	}
}

public class ConstructorDemo extends Plant {

	private ConstructorDemo(int vData) {
		super(vData);
	}
	
	public static void main(String... a) {// TODO
//		super.equals(a);
		/*
		 * ConstructorDemo demo = new ConstructorDemo(1890);
		 * System.out.println(ConstructorDemo.vData);
		 */
	}

	
}

