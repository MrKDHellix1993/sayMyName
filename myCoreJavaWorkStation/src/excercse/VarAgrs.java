package excercse;

import java.util.Arrays;

public class VarAgrs {

	public static void main(String... a) {// TODO
		// varprint("kd","sdfds", "4");
		int n = 10;
//		int list[] = new int[n];
		int list[] = {85, 51, 83, 71, 82, 82, 18, 91, 11, 54};
		
		/*
		 * for (int i = 0; i < list.length; i++) { list[i] = (int)( Math.random()*100);
		 * }
		 */
		
		for (int pi : list) {
			System.out.println("my randon array ele " + pi);
		}
		
		int v = Arrays.binarySearch(list, 11);
		System.out.println("searfch ele index b4 sort " + v);
		
		Arrays.sort(list);
		
		 v = Arrays.binarySearch(list, 11);
		System.out.println("searfch ele index after sort " + v);
		/*
		 * for (int pi : list) { int v = Arrays.binarySearch(list, 12);
		 * System.out.println("searfch ele index " + v); }
		 *///		String list[] = {"Java" , "Apple", "google" , "Amazon"};
	}

	public static void varprint(String b, String... a) {// TODO
		for (String vr : a) {
			System.out.println("vr vales " + vr);
		}
	}

}
