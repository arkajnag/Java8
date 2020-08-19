package example.Threading.ImplementsRunnable;

/*
 * Runnable Interface to be used when planning to override the Run implementation.
 * 
 */


import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Supplier;
import java.util.stream.IntStream;


class library implements Runnable{

	private String bookName;
	private String bookAuthor;
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getBookAuthor() {
		return bookAuthor;
	}
	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}
	public library(String bookName, String bookAuthor) {
		this.bookName = bookName;
		this.bookAuthor = bookAuthor;
	}
	
	public void displayBookDetails(){
		System.out.println("Thread Execution:"+Thread.currentThread().getName()+". Book Name:"+this.getBookName()+" and it's Author:"+this.getBookAuthor());
	}
	
	public void run() {
		displayBookDetails();
	}
	
}
public class RunnableInterfaceExample1 {
	public static Supplier<Integer> getRandomNumber=()->new Random().nextInt(1000);
	public static void main(String[] args) {
		List<library> listOfbooks=new ArrayList<>();
		IntStream.iterate(0, i->i+1).limit(30).forEach(i->listOfbooks.add(new library("BookName-"+getRandomNumber.get(), "BookAuthor-"+getRandomNumber.get())));
		
		ExecutorService executor=Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
		IntStream.range(0, listOfbooks.size()).forEach(i->executor.submit(new library(listOfbooks.get(i).getBookName(),listOfbooks.get(i).getBookAuthor())));
		
		System.out.println("State of Executor Threads:"+executor.isTerminated());	
	}

}
