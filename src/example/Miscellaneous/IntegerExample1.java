package example.Miscellaneous;

import java.util.Scanner;

public class IntegerExample1 {

	public static int incrementEachDigit(int value) {
		int newNumber = 0;
		int actualValue=value;
		while (actualValue != 0) {
			value=actualValue;
			while (value >= 10) {
				value = value / 10;
			}
			System.out.println("Value:" + value);
			newNumber = newNumber * 10 + (value + 1);
			if(actualValue>100){
			actualValue = actualValue % 100;
			}else if(actualValue<100 && actualValue>10){
				actualValue = actualValue % 10;
			}else{
				break;
			}
		}
		return newNumber;
	}

	public static void main(String[] args) {
		Scanner si = new Scanner(System.in);
		System.out.print("Please input your number:");
		int value = si.nextInt();
		System.out.println(incrementEachDigit(value));
		si.close();

	}

}
