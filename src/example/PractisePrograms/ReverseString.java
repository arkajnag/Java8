package example.PractisePrograms;

import java.util.Scanner;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ReverseString {

	public static UnaryOperator<String> reverseStringUsingLoop = inputStr -> {
		String revStr = "";
		for (int i = inputStr.length() - 1; i >= 0; i--) {
			revStr = revStr + inputStr.charAt(i);
		}
		return revStr;
	};

	public static UnaryOperator<String> reverseStringUsingIntStream = inputStr -> {
		String revStr = "";
		int end = inputStr.length() - 1;
		int start = 0;
		return IntStream.iterate(end, i -> i - 1).limit(end - start + 1)
				.mapToObj(val -> (revStr + inputStr.charAt(val)).toString()).collect(Collectors.joining(""));
	};

	//Not Thread Safe. StringBuffer is synchronised and thread-safe
	public static UnaryOperator<String> reverseStringUsingStringBuilder = inputStr -> new StringBuilder(inputStr)
			.reverse().toString();

	public static void main(String[] args) {
		Scanner si = new Scanner(System.in);
		System.out.print("Please enter your string:");
		String str = si.nextLine();
		System.out.println("Reverse String Using UnaryOperator and For Loop:" + reverseStringUsingLoop.apply(str));
		System.out.println(
				"Reverse String Using UnaryOperator and For IntStream:" + reverseStringUsingIntStream.apply(str));
		si.close();
	}

}
