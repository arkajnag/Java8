package example.PractisePrograms;

import java.util.Scanner;
import java.util.function.Consumer;
import java.util.stream.IntStream;

public class PrimeNumbersInRangeUsingJava8 {

	public static Consumer<Integer> findPrimeNumbersInRange = new Consumer<Integer>() {
		public void accept(Integer range) {
			int minRange = 2;
			while (minRange < range) {
				boolean[] flag = { false };
					int val = minRange;
					IntStream.rangeClosed(2, val/2).filter(i -> val % i == 0)
							.forEach(i -> flag[0] = true);
					if(!flag[0])
						System.out.println("Number:"+val+" is a PRIME Number");
					else
						System.out.println("Number:"+val+" is not PRIME Number");
					++minRange;
				}
		}

	};

	public static void main(String[] args) {
		Scanner si = new Scanner(System.in);
		System.out.print("Please enter your range:");
		int rangeVal = si.nextInt();
		findPrimeNumbersInRange.accept(rangeVal);
		si.close();
	}

}
