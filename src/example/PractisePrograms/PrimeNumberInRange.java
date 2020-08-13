package example.PractisePrograms;

import java.util.Scanner;
import java.util.function.Consumer;
import java.util.stream.IntStream;

public class PrimeNumberInRange {

	public static Consumer<Integer> findPrimeNumbersInRange = new Consumer<Integer>() {
		public void accept(Integer range) {
			final boolean[] flag = { false };
			final int[] n={0}; 
			if (range == 0 || range == 1)
				throw new RuntimeException("Please consider numbers outside 0 or 1");
			else {
				for (int j = 2; j < range; j++) {
					n[0]=j;
					IntStream.iterate(2, i->i+1).limit(n[0]/2).filter(i->n[0]%i==0).forEach(i->flag[0]=true);
					if(!flag[0])
						System.out.println("Number:"+j+" is a PRIME number");
					else
						System.out.println("Number:"+j+" is not a PRIME number");
				}
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
