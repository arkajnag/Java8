package example.PractisePrograms;

import java.util.Scanner;
import java.util.function.UnaryOperator;

public class FirstAndLastNumber {
	
	public static UnaryOperator<Integer> findFirstDigit=val->{
		while(val>10){
			val=val/10;
		}
		return val;
	};
	
	public static UnaryOperator<Integer> findLastDigit=val->val=val%10;	
	
	public static void main(String[] args) {
		Scanner si=new Scanner(System.in);
		System.out.print("Please enter your number:");
		int num=si.nextInt();
		System.out.println("First Digit of Number:"+findFirstDigit.apply(num));
		System.out.println("Last Digit of Number:"+findLastDigit.apply(num));
		si.close();
	}

}
