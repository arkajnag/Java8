package example.Threading.ExtendsThreadClass;

/*
 * Creating threads extending Thread Class, which will be triggered along side Main thread.
 * The extending class needs to override the run method. Within the run() , you can include another method which to be triggered in multithreading action.
 * ExecutorService can't be used when extending Thread class as it accepts only Runnable or Callable Objects.
 * When create Object of Extending class, we can implement method of parent Thread class like, start(), stop(), isAlive(), isDeamon(), getState()
 * With loops, we can create as many threads, we want based on Available Processors.
 * Restricted flexbility of using concept of Thread-pool and concept of proper queuing. ExecutorService of java.util.concurrent helps in performing this.
 * 
 * Thread implements Runnable Interface.
 */


import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

class Emp extends Thread {
	private String empName;

	public Emp(String empName) {
		this.empName = empName;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	
	public void run(){
		System.out.println("Name of the Employee:"+this.getEmpName()+" and workig thread:"+Thread.currentThread().getName());
	}
}

public class ExampleMultiThreading1 {

	public static void main(String[] args) {
		
		List<Emp> listOfEmps=Arrays.asList(new Emp("Tester1"),new Emp("Tester2"),
				new Emp("Tester3"),new Emp("Tester4"),new Emp("Tester5"),new Emp("Tester6"),new Emp("Tester7"),new Emp("Tester8"));
		IntStream.range(0, listOfEmps.size()).forEach(i->new Emp(listOfEmps.get(i).getEmpName()).start());
	}

}
