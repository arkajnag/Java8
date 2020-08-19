package example.Threading.ExtendsThreadClass;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.IntStream;

class Student extends Thread{
	
	private String studentFName;
	private String studentLName;
	public Student(String studentFName, String studentLName) {
		this.studentFName = studentFName;
		this.studentLName = studentLName;
	}
	public String getStudentFName() {
		return studentFName;
	}
	public void setStudentFName(String studentFName) {
		this.studentFName = studentFName;
	}
	public String getStudentLName() {
		return studentLName;
	}
	public void setStudentLName(String studentLName) {
		this.studentLName = studentLName;
	}
	
	/*
	 * synchronized access modifiers. Allowing access to the method or variable simultaneously. Making thread safe.
	 */
	public synchronized String getStudentFullName(){
		return "Student Fullname:"+this.studentFName+" "+this.studentLName;
	}
	
	public void run(){
		System.out.println("Thread Name:"+Thread.currentThread().getName()+" and it's priority:"+Thread.currentThread().getPriority()+" and state:"+Thread.currentThread().getState());
		System.out.println(getStudentFullName());
	}
	public Student(){
		
	}
	
}

public class ExampleMultiThreading2 {

	public static Supplier<Integer> getRandomNumber=()->new Random().nextInt(100);
	
	public static void main(String[] args) {
		List<Student> listOfStudents=new ArrayList<>();
		IntStream.iterate(0, i->i+1).limit(30).forEach(i->listOfStudents.add(new Student("FName"+getRandomNumber.get(), "LName"+getRandomNumber.get())));
		
		IntStream.range(0,listOfStudents.size()).forEach(i->new Student(listOfStudents.get(i).getStudentFName(),listOfStudents.get(i).getStudentLName()).start());

	}

}
