package example.PractisePrograms.Collections;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

class Student {
	private Integer studentID;
	private String studentName;
	private String studentSchool;

	public Integer getStudentID() {
		return studentID;
	}

	public void setStudentID(Integer studentID) {
		this.studentID = studentID;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentSchool() {
		return studentSchool;
	}

	public void setStudentSchool(String studentSchool) {
		this.studentSchool = studentSchool;
	}

	public Student(Integer studentID, String studentName, String studentSchool) {
		this.studentID = studentID;
		this.studentName = studentName;
		this.studentSchool = studentSchool;
	}

	public Student() {

	}

	@Override
	public String toString() {
		return "Student [studentID=" + studentID + ", studentName=" + studentName + ", studentSchool=" + studentSchool
				+ "]";
	}

}

public class MapFrameworkImplementation {

	public static void main(String[] args) {
		Map<Integer, Student> studentDetails = new HashMap<>();
		studentDetails.put(101, new Student(1, "Ganesh", "JMHS"));
		studentDetails.put(112, new Student(4, "Suresh", "XYV"));
		studentDetails.put(103, new Student(2, "Vijesh", "MMK"));
		studentDetails.put(14, new Student(9, "Jignesh", "BBC"));
		studentDetails.put(214, new Student(11, "Yogesh", "ABCD"));
		studentDetails.put(159, new Student(59, "Mukesh", "MMK"));
		studentDetails.put(611, new Student(98, "Kukesh", "MMK"));
		studentDetails.put(872, new Student(29, "Hulesh", "ABCD"));

		// Converting the Map into List Collection.
		List<Entry<Integer, Student>> entrySetStudentList = studentDetails.entrySet().stream()
				.collect(Collectors.toList());
		entrySetStudentList
				.forEach(entry -> System.out.println("Key:" + entry.getKey() + "   Value:" + entry.getValue()));

		System.out.println("");
		// Sorting Map based on Key
		entrySetStudentList.stream().map(entry -> entry.getKey()).sorted().forEach(System.out::println);

		System.out.println("");
		// Sorting Map based on Value:StudentName
		entrySetStudentList.stream().sorted((Entry<Integer, Student> o1, Entry<Integer, Student> o2) -> {
			return o1.getValue().getStudentName().compareToIgnoreCase(o2.getValue().getStudentName());
		}).forEach(entry -> System.out.println("Key:" + entry.getKey() + "   Value:" + entry.getValue()));

		System.out.println("");
		// Filtering Map Entry based on Conditional Match
		entrySetStudentList.stream().filter(entry -> entry.getValue().getStudentSchool().equalsIgnoreCase("MMK"))
				.forEach(entry -> System.out.println("Key:" + entry.getKey() + "   Value:" + entry.getValue()));
	}

}
