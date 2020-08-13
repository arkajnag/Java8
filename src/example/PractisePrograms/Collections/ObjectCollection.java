package example.PractisePrograms.Collections;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Employee{
	
	private String empName;
	private String empDept;
	private Integer empAge;
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpDept() {
		return empDept;
	}
	public void setEmpDept(String empDept) {
		this.empDept = empDept;
	}
	public Integer getEmpAge() {
		return empAge;
	}
	public void setEmpAge(Integer empAge) {
		this.empAge = empAge;
	}
	public Employee(String empName, String empDept, Integer empAge) {
		this.empName = empName;
		this.empDept = empDept;
		this.empAge = empAge;
	}
	public Employee() {
	}
	@Override
	public String toString() {
		return "Employee [empName=" + empName + ", empDept=" + empDept + ", empAge=" + empAge + "]";
	}
}
public class ObjectCollection {

	public static void main(String[] args) {
		//Creating List of Employees using Arrays.asList();
		List<Employee> empListByArrays=Arrays.asList(new Employee("Emp153","Test",35),
				new Employee("Emp212","Dev",32),
				new Employee("Emp3","Manager",40),
				new Employee("Emp411","Architect",39));
		
		//Creating List of Employees using Stream;
		List<Employee> empListByStream=Stream.of(new Employee("Emp111","Test",35),
				new Employee("Emp12","Dev",32),
				new Employee("Emp1","Manager",40),
				new Employee("Emp198","Architect",39)).collect(Collectors.toList());

		//Using toString to display the Employee Object and Displaying all Data
		System.out.println("Using toString to display the Employee Object and Displaying all Data");
		empListByArrays.forEach(System.out::println);
		
		System.out.println("");
		System.out.println("Sorting Employee Object List based on EmpAge in Descending Order");
		//Sorting Employee Object List based on EmpAge in Descending Order
		empListByStream.stream().sorted((o1,o2)-> (o1.getEmpAge()>o2.getEmpAge())?-1:(o1.getEmpAge()<o2.getEmpAge())?1:0).forEach(System.out::println);
		
		System.out.println("");
		System.out.println("Sorting Employee Object List based on EmpName");
		empListByArrays.stream().sorted((o1,o2)->o1.getEmpName().compareToIgnoreCase(o2.getEmpName())).forEach(System.out::println);
		
		System.out.println("");
		System.out.println("Getting Employee Details with Max Age");
		System.out.println("Employee with Max Age:"+empListByArrays.stream().max((o1,o2)->o1.getEmpAge().compareTo(o2.getEmpAge())).get());
		
		System.out.println("");
		System.out.println("Getting Employee Details with Min Age");
		System.out.println("Employee with Min Age:"+empListByArrays.stream().min((o1,o2)->o1.getEmpAge().compareTo(o2.getEmpAge())).get());
		
		System.out.println("");
		System.out.println("Getting Sum of all Employee Ages");
		Integer sumOfAges=empListByArrays.stream().map(o1->o1.getEmpAge()).collect(Collectors.summingInt(age->age));
		System.out.println("Sum of Ages Using Collect:"+sumOfAges);

		Integer sumByMap=empListByArrays.stream().mapToInt(emp->emp.getEmpAge()).sum();
		System.out.println("Sum of Ages Using MapToInt and Sum:"+sumByMap);
		
		System.out.println("");
		System.out.println("Convert List into Map Collections Framework using ForEach");
		Map<Integer,Employee> empMap=new HashMap<>();
		empListByArrays.stream().forEach(emp->empMap.put(ThreadLocalRandom.current().nextInt(), emp));
		for(Map.Entry<Integer, Employee> entry:empMap.entrySet())
			System.out.println("Key:"+entry.getKey()+" Value:"+entry.getValue());
		
		System.out.println("");
		System.out.println("Convert List into Map Collections Framework using Collectors");
		Map<String,Employee> empMapCollectors=new HashMap<>();
		empMapCollectors=empListByArrays.stream().collect(Collectors.toMap(Employee::getEmpName,emp->emp));
		for(Map.Entry<String,Employee> entry:empMapCollectors.entrySet())
			System.out.println("Key:"+entry.getKey()+" Value:"+entry.getValue());
	}

}
