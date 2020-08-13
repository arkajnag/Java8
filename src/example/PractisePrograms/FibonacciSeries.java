package example.PractisePrograms;

import java.util.Scanner;
import java.util.function.IntConsumer;
import java.util.stream.IntStream;

public class FibonacciSeries {
	
	public static void findFibonacciSeries(int range) {
		long startTime=System.currentTimeMillis();
		int num1=0;
		int num2=1;
		int sum=0;
		for(int i=0;i<range;i++){
			System.out.print(num1+" ");
			sum=num1+num2;
			num1=num2;
			num2=sum;
		}
		long endTime=System.currentTimeMillis();
		System.out.println("");
		System.out.println("Total time taken using Basic Loop:"+(endTime-startTime)+" ms");
	}
	
	public static void findFibonacciUsingIntStream(int range){
		long startTime=System.currentTimeMillis();
		IntStream.range(0, range).forEach(new IntConsumer(){
			int num1=0;
			int num2=1;
			int sum=0;
			public void accept(int i) {
				System.out.print(num1+" ");
				sum=num1+num2;
				num1=num2;
				num2=sum;
			}
		});
		long endTime=System.currentTimeMillis();
		System.out.println("");
		System.out.println("Total time taken using IntStream:"+(endTime-startTime)+" ms");
	}
	
	public static int findFibonacciUsingRecursion(int num){
		return (num==0)?0:(num==1)?1:findFibonacciUsingRecursion(num-1)+findFibonacciUsingRecursion(num-2);
	}
	
	public static void main(String[] args)  {
		Scanner si=new Scanner(System.in);
		System.out.print("Please enter your range:");
		int range=si.nextInt();
		findFibonacciSeries(range);
		System.out.println("");
		findFibonacciUsingIntStream(range);
		System.out.println("");
		IntStream.range(0, range).forEach(i->System.out.print(findFibonacciUsingRecursion(i)+" "));
		si.close();
	}

}
