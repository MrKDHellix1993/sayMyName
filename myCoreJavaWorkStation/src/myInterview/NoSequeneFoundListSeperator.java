package myInterview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NoSequeneFoundListSeperator {
	public static List<List<Integer>> findNoSequeneFoundListSeperator(List<Integer> inputList) {
		List<List<Integer>> lList = null;
		List<Integer> copy = null;
		if (null != inputList) {
			lList = new ArrayList<List<Integer>>(); // list of list of integer
			System.out.println("list:" + inputList);
			copy =  new ArrayList<Integer>(inputList); 
			int i = 0;
			int chop = 0;
			List<Integer> sList = new ArrayList<Integer>(2);
			for (i = 1; i < inputList.size
					(); i++) {
				if ((inputList.get(i) - inputList.get(i - 1)) == 1) {
					sList.add(inputList.get(i - 1));
					// sList.add(list.get(i));
				} else {
					sList.add(inputList.get(i - 1));
					lList.add(sList);
					chop = i;
					System.out.println("New Spliter index " + chop);
					sList = new ArrayList<Integer>(2);
				}

			}
			// sList.add(list.get(start)); // for last range
			sList.add(inputList.get(inputList.size() - 1));
			lList.add(sList);
			System.out.println("Range :" + lList);
		}
		return lList;
	}

	public static void main(String[] a) {
		List<Integer> inputList = Arrays.asList(2, 3, 4, 5, 8, 10, 11, 12, 15, 16, 17, 18, 19, 25);
//			List<Integer> list = Arrays.asList( 1, 2, 3, 5, 6, 8, 9, 11, 12);
		System.out.println(findNoSequeneFoundListSeperator(inputList));
	}
}
