package example.PractisePrograms;

import java.util.Scanner;
import java.util.function.UnaryOperator;

public class ReverseNumber {
	
	public static UnaryOperator<Integer> reverseNumberUsingWhileLoop=val-> {
			int revNumber=0;
			while(val!=0){
				revNumber=revNumber*10+val%10;
				val=val/10;
			}
			return revNumber;
	};
	
	public static UnaryOperator<Integer> reverseNumberUsingStringBuffer=val-> Integer.parseInt(new StringBuffer(String.valueOf(val)).reverse().toString());
	
	public static void main(String[] args) {
		Scanner si=new Scanner(System.in);
		System.out.print("Please enter your number:");
		int num=si.nextInt();
		System.out.println("Reverse Number using Loop:"+reverseNumberUsingWhileLoop.apply(num));
		System.out.println("");
		System.out.println("Reverse Number using StringBuffer:"+reverseNumberUsingStringBuffer.apply(num));
		si.close();
	}

}
