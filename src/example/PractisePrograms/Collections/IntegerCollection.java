package example.PractisePrograms.Collections;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class IntegerCollection {

	public static void main(String[] args) {

		// 1. Creating a new List Using Stream
		List<Integer> numbers = Stream.of(12, 18, 20, 11, 9, 36, 29).collect(Collectors.toList());
		// 2. Print all the Numbers of List
		numbers.stream().forEach(i -> System.out.print(i + " "));
		System.out.println("");
		// 3. Filtering and Showing only numbers which are Even
		List<Integer> evenNumbers = numbers.stream().filter(i -> i % 2 == 0).collect(Collectors.toList());
		evenNumbers.forEach(i -> System.out.print(i + " "));
		System.out.println("");
		// 4. Filtering only Odd Numbers and reverse them and display them
		List<Integer> oddNumbersReversed=numbers.stream().filter(i -> i % 2 != 0)
				.map(i -> Integer.parseInt(new StringBuffer(String.valueOf(i)).reverse().toString()))
				.collect(Collectors.toList());
		oddNumbersReversed.forEach(i -> System.out.print(i + " "));
		System.out.println("");
		// 5. Sorting default without any customised condition
		numbers.stream().sorted().forEach(i -> System.out.print(i + " "));
		System.out.println("");
		// 6. Sorting in Descending Order using Comparator Functional Interface
		numbers.stream().sorted((int1,int2)->(int1>int2)?-1:(int1<int2)?1:0).forEach(i -> System.out.print(i + " "));
		
	}

}
