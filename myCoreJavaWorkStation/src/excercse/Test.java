package excercse;

public class Test {

	public static void main(String... a) {// TODO
		/*
		 * Bitiwse Operators int c1 = 25; int c2 = 20; if((c1 ^ c2) ==5) {
		 * System.out.println("its exor op"); } else {
		 * System.out.println("its not exor op"); } System.out.println((c1 & c2));
		 * System.out.println((c1 | c2)); System.out.println((c1 ^ c2));
		 * System.out.println((c1 &= c2)); System.out.println("c1 " + c1);
		 * 
		 * System.out.println("c1 " + c1); System.out.println((c1 ^= c2));
		 * System.out.println((c1>>2));
		 */

		/*
		 * Java Data type conversion byte b = 65; int c = b;
		 * System.out.println(" byte > int" + c);
		 * 
		 * b = (byte)(c*2); System.out.println(" int > byte" + b);
		 */
		/*
		 * //Java octal & hexa int b = 0136; //oc int p = 0X136;// hexa int c = -7;
		 * System.out.println(b%c + "" + p);
		 */

		/*
		 * int az =5; az *= 5+9; System.out.println(az);
		 * 
		 * int p = 5, u = 6, z = 0; if (++p >= u) { u = 2; } System.out.println( p + u);
		 */
		/*
		 * System.out.println(GepmetricArea.area(5.9f)); NormalArea gepmetricArea = new
		 * NormalArea(); System.out.println(gepmetricArea.area(15.6f));
		 * System.out.println(GepmetricArea.id); System.out.println(gepmetricArea.id);
		 * area(100.0d);
		 */
		
		GeometricArea g1 = new GeometricArea();
		System.out.println(" g1 counter" + g1.id);
		GeometricArea g2 = new GeometricArea();
		GeometricArea g3 = new GeometricArea();
		System.out.println(" counter" + GeometricArea.id);
		System.out.println(" g1 counter" + g1.id);
		
	}

	public static double area(double r) {
		// area(56.0d,15.0d);
		System.out.println(" inside GepmetricArea staic area");
		return 3.14 * r * r;
	}

	protected double area(double length, double width) {
		area(5.96d);
		return length * width;
	}
}

class GeometricArea {

	static int id = 0;

	public GeometricArea() {
		id++;
	}

	public static float area(float r) {
		System.out.println(" inside GepmetricArea staic area");
		return 3.14f * r * r;
	}

	protected double area(double length, double width) {
		return length * width;
	}
}

class NormalArea extends GeometricArea {
	public static float area(float r) {
		id = 5;
		System.out.println(" inside NormalArea staic area");
		return (3.14f * r * r) + 1;
	}
}
