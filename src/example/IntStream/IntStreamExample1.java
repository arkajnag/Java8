package example.IntStream;

import java.util.concurrent.ThreadLocalRandom;
import java.util.function.IntSupplier;
import java.util.function.IntUnaryOperator;
import java.util.stream.IntStream;

public class IntStreamExample1 {
	
	public static void main(String[] args) {
		
		IntStream.rangeClosed(0, 5).forEach(i->System.out.println("Hello:"+i));
		
		System.out.println(" ");
		IntStream.generate(new IntSupplier(){
			public int getAsInt() {
				return ThreadLocalRandom.current().nextInt(1, 100);
			}
		}).limit(5).forEach(i->System.out.println("Hello Random Number:"+i));
	
		System.out.println(" ");
		IntStream.of(12,14,15,56,33).forEach(i->System.out.println("Hello IntStream of:"+i));
		
		System.out.println(" ");
		IntStream.generate(()->ThreadLocalRandom.current().nextInt(10, 50))
		.limit(10)
		.filter(value->value%2==0)
		.forEach(i->System.out.println("Hello Even Number:"+i));
		
		System.out.println(" ");
		IntStream.iterate(0, new IntUnaryOperator() {
			public int applyAsInt(int i) {
				return i+1;
			}
		}).limit(10).filter(value->value%2==0).forEach(i->System.out.println("Hello Using Iterate:"+i));
	}

}
