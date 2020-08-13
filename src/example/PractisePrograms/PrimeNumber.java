package example.PractisePrograms;

import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.IntStream;

public class PrimeNumber {
	
	public static Function<Integer,String> findWhetherPrimeorNot=val-> {
			final boolean flag[]={false};
			if(val==0 || val==1)
				throw new RuntimeException("0 or 1 is not allowed.");
			else{
				IntStream.rangeClosed(2,val/2).filter(i->val%i==0).forEach(i->flag[0]=true);
				if(!flag[0])
					return "Number:"+val+" is a prime number";
				else
					return "Number:"+val+" is not a prime number";
			}
	};
	
	public static void main(String[] args) {
		Scanner si=new Scanner(System.in);
		System.out.print("Please enter your Number:");
		int num=si.nextInt();
		System.out.println(findWhetherPrimeorNot.apply(num));
		si.close();
	}

}


//for(int i=2;i<val/2;i++){
//if(val%i==0){
//	flag=true;
//	break;
//}
//}
