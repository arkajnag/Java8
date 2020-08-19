package example.PractisePrograms;

import java.util.Scanner;
import java.util.function.UnaryOperator;

public class Factorial {

	private static UnaryOperator<Integer> factorialOfNumber=new UnaryOperator<Integer>(){
		public Integer apply(Integer num) {
			if(num==0)
				return 1;
			else
				return num*factorialOfNumber.apply(num-1);
		}
	};
	
	public static void main(String[] args) {
		Scanner si=new Scanner(System.in);
		System.out.print("Please enter your number:");
		int num=si.nextInt();
		System.out.println("Factorial of Number:"+num+" is:"+factorialOfNumber.apply(num));
		si.close();
	}

}
