package example.PractisePrograms;

import java.util.Scanner;

public class PrimeNumberWithoutJava8 {

	public static void findPrimeNumbersInRange(int range){
		int lowRange=2;
		while(lowRange<range){
			boolean flag=false;
				for(int i=2;i<lowRange/2;i++){
					if(lowRange%i==0){
						flag=true;
						break;
					}
				}
				if(!flag)
					System.out.println("Number:"+lowRange+" is a PRIME Number");
				else
					System.out.println("Number:"+lowRange+" is not PRIME Number");
				lowRange++;
			}
			
	}
	
	public static void main(String[] args) {
		Scanner si=new Scanner(System.in);
		System.out.print("Please enter your range:");
		int rangeVal=si.nextInt();
		findPrimeNumbersInRange(rangeVal);
		si.close();
	}

}
