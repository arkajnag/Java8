package example.PractisePrograms;

import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.function.UnaryOperator;

public class PalindromeUsingJava8 {
	
	public static UnaryOperator<String> reverseStringUsingStringBuilder = inputStr -> new StringBuilder(inputStr)
			.reverse().toString();
	
	public static BiFunction<UnaryOperator<String>,String,String> verifyPalindromeOrNot=new BiFunction<UnaryOperator<String>,String,String>(){
		public String apply(UnaryOperator<String> t,String inputStr) {
			return (t.apply(inputStr).equalsIgnoreCase(inputStr))?"String:"+inputStr+" is a PALINDROME":"String:"+inputStr+" is not a PALINDROME";
		}
	};

	public static void main(String[] args) {
		Scanner si = new Scanner(System.in);
		System.out.print("Please enter your string:");
		String str = si.nextLine();
		System.out.println(verifyPalindromeOrNot.apply(reverseStringUsingStringBuilder, str));
		si.close();

	}

}
