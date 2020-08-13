package example.Miscellaneous;

import java.util.Scanner;

public class IntegerExample2 {
	
	
	
	public static void main(String[] args) {
		Scanner si = new Scanner(System.in);
		System.out.print("Please input your number:");
		int value = si.nextInt();
		System.out.println(incrementEachDigit(value));
		si.close();
	}

	private static int incrementEachDigit(int value) {
		int newValue=0;
		int newValue2=0;
		while(value>0){
			newValue=value%10;
			newValue++;
			newValue2=newValue2*10+newValue;
			value=value/10;
		}
		value=newValue2;
		System.out.println("Value:"+value);
		newValue=0;
		while(value!=0){
			newValue=newValue*10+value%10;
			value=value/10;
		}
		return newValue;
	}
	

}
