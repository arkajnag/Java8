package example.Miscellaneous;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class IntegerExample4 {
	
	public static void main(String[] args) {
		Scanner si = new Scanner(System.in);
		System.out.print("Please input your number:");
		int value = si.nextInt();
		System.out.println(incrementEachDigit(value));
		si.close();
	}

	private static int incrementEachDigit(int value) {
		long startTime=System.currentTimeMillis();
		ArrayList<Integer> a=new ArrayList<>();
		int revNum=0;
		while(value>0){
			revNum=value%10;
			a.add(revNum+1);
			revNum=revNum*10;
			value=value/10;
		}
		Collections.reverse(a);
		String newValue=IntStream.range(0, a.size()).mapToObj(i-> a.get(i).toString()).map(str->{
			String result = "";
			result=result.concat(str);
			return result;
		}).collect(Collectors.joining(""));
		long endTime=System.currentTimeMillis();
		System.out.println("Total Time taken:"+(endTime-startTime));
		return Integer.parseInt(newValue);
	}
}
