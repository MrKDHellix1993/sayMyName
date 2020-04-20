package excercse;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestJava8Demo {
	
	    public static String[] uniqueNames(String[] names1, String[] names2) {
		
		  List<String> names1List = Arrays.asList(names1); List<String> names2List =
		  Arrays.asList(names2); names1 =Stream.concat(names1List.stream(),
		  names2List.stream()).distinct().collect(Collectors.toList()).toArray(new
		  String[0]); // names1 = Arrays.copyOf(tem, tem.length , String[].class);
		  return names1;
		// Math.sqrt(a)
		/*
		 * names1 = Stream.concat(Arrays.stream(names1),
		 * Arrays.stream(names2)).distinct().collect(Collectors.toList()).toArray(new
		 * String[0]); return names1;
		 */
	    }
	    
	    public static void main(String[] args) {
	        String[] names1 = new String[] {"Ava", "Ava" ,"Emma", "Olivia" , "Olivia" , "Emma"};
	        String[] names2 = new String[] {"Olivia", "Sophia", "Emma"};
	        System.out.println(String.join(", ", TestJava8Demo.uniqueNames(names1, names2))); // should print Ava, Emma, Olivia, Sophia
	    }

	/*
	 * public static void varprint(String b, String... a) {// TODO for (String vr :
	 * a) { System.out.println("vr vales " + vr); }
	 
	} */

}


/*
 * Implement the uniqueNames method. When passed two arrays of names, it will
 * return an array containing the names that appear in either or both arrays.
 * The returned array should have no duplicates.
 * 
 * For example, calling MergeNames.uniqueNames(new String[]{'Ava', 'Emma',
 * 'Olivia'}, new String[]{'Olivia', 'Sophia', 'Emma'}) should return an array
 * containing Ava, Emma, Olivia, and
 */