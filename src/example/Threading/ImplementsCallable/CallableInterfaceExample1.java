package example.Threading.ImplementsCallable;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Supplier;
import java.util.stream.IntStream;

class Booking implements Callable<String> {

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

	public Booking(String bookName, String bookAuthor) {
		this.bookName = bookName;
		this.bookAuthor = bookAuthor;
	}

	public String displayBookDetails() {
		return "Thread Execution:" + Thread.currentThread().getName() + ". Book Name:" + this.getBookName()
				+ " and it's Author:" + this.getBookAuthor();
	}

	@Override
	public String call() throws Exception {
		return displayBookDetails();
	}
}

public class CallableInterfaceExample1 {
	public static Supplier<Integer> getRandomNumber = () -> new Random().nextInt(1000);

	public static void main(String[] args) {
		List<Booking> listOfbooks = new ArrayList<>();
		ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
		IntStream.iterate(0, i -> i + 1).limit(30).forEach(i -> listOfbooks
				.add(new Booking("BookName-" + getRandomNumber.get(), "BookAuthor-" + getRandomNumber.get())));

		IntStream.range(0, listOfbooks.size()).mapToObj(i -> {
			String responseFuture = "";
			try {
				responseFuture = executor
						.submit(new Booking(listOfbooks.get(i).getBookName(), listOfbooks.get(i).getBookAuthor()))
						.get();
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
			return responseFuture;
		}).forEach(System.out::println);
		System.out.println("State of Executor Threads:" + executor.isTerminated());
	}

}
