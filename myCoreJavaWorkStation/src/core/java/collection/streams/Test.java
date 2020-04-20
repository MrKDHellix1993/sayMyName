package core.java.collection.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Test {

	public static void main(String[] a) {
//		List<Integer> inputList = Arrays.asList(new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 });
		List<Integer> inputList = Arrays.asList(new Integer[] { 0, 3, 3, 1, 2, 6, 8,5 });
		int inputArray[] = { 0, 5, 6, 2, 3, 3, 0 };
//		StreamDemo.streamManupulatorForPremetives(inputArray);
		StreamDemo.streamManupulatorForObjects(inputList);
	}
}

class StreamDemo {
	public static List<Integer> streamManupulatorForObjects(List<Integer> input) {
		List<Integer> greater = null;
		try {
			
			greater = new ArrayList<Integer>();
			List<Integer> less = new ArrayList<Integer>();
			if(null != input)
			{
				greater = input.stream().distinct().filter(a -> a>= 5).collect(Collectors.toList());
				less = input.stream().distinct().filter(a -> a < 5).collect(Collectors.toList());
				System.out.println("oz list " + input);
				greater.addAll(less);
				System.out.println("final list " + greater);
			}
		}catch (Exception e) {
			try {
				
			}catch(Exception e1) {
				
			}
		}
		return greater;
	}

	public static void streamManupulatorForPremetives(int inputArray[]) {
		// find minimun in list
		int inputArrayCopy[] = Arrays.copyOf(inputArray, inputArray.length);
		IntStream str = IntStream.of(inputArrayCopy);
		str.min().ifPresent(System.out::println);
		str.max().ifPresent(System.out::println);
		IntSummaryStatistics stat = str.summaryStatistics();
		System.out.println("Avg . : " + stat.getAverage());

		// find 3 distint smallest in list
		str.distinct().sorted().limit(3).boxed().forEach(a -> System.out.print(" " + a));
		
	}
}
