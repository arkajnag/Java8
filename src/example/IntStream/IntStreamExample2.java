package example.IntStream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class IntStreamExample2 {
	
	public static void main(String[] args) {
		
		List<Integer> numbers=Stream.of(9,4,16,18,29,13,11,89,54).collect(Collectors.toList());
		
		IntStream.iterate(0, i->i+1).limit(numbers.size()-1)
		.filter(num->num%2==0)
		.mapToObj(num->("Number-"+num).toString())
		.forEach(System.out::println);
	}

}
