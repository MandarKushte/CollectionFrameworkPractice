package demo.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.TreeSet;
import java.util.Vector;

class Employee{
	
	int empId;
	String empName;
	int empIncrement;
	
	public Employee(int empId, String empName, int empIncrement) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empIncrement = empIncrement;
	}

	@Override
	public String toString() {
		return "\n [empId=" + empId + ", empName=" + empName + ", empIncrement=" + empIncrement + "]";
	}
	
}

class Student {
	int rollNum;
	String name;
	int marks;
	
	public Student(int rollNum, String name, int marks) {
		super();
		this.rollNum = rollNum;
		this.name = name;
		this.marks = marks;
	}

	@Override
	public String toString() {
		return "\n [rollNum=" + rollNum + ", name=" + name + ", marks=" + marks + "]";
	}
	
}

class MarksComparator implements Comparator<Student>{
	
	@Override
	public int compare(Student o1, Student o2) {
		return o2.marks - o1.marks;
	}
	
}

public class BusinessClass {

	public static void main(String[] args) {
		
		// Question 1 -> Create an arraylist & remove those names starting with "K".
//		ArrayList<String> l1 = new ArrayList<>(Arrays.asList("Kavitha","Mangesh","Avanti","Kamlesh","Ajay",
//			"Zenath","kranti"));
//		System.out.println("Arraylist l1 : " + l1);
//		removeStringsUsingListIterator(l1);
//		removeStringsUsingEnumeration(l1);
		
		// Question 2 -> Create an arraylist of Employees with empId, empName & empIncrement.
		// 				 & Keep only those Employees whose increment is greater than 10.
//		ArrayList<Employee> l2 = new ArrayList<>(Arrays.asList(
//				new Employee(101, "Aditi", 10), new Employee(102, "Kavya", 5),
//				new Employee(103, "Madhu", 6), new Employee(104, "Sushant", 23),
//				new Employee(105, "Abhijeet", 12), new Employee(106, "Suresh", 4),
//				new Employee(107, "Chandu", 11)				
//					));
//		System.out.println("Employee List is : \n" + l2);
//		sortListUsingIncrement(l2);
		
		// Question 3 -> Create a vector of 10 names, Remove duplicate from it, and arrange them in reverse
		//				 Dictionary order.
//		Vector<String> v1 = new Vector<>(new ArrayList<>(Arrays.asList("Kavitha","Mangesh","Avanti",
//				"Kamlesh","Ajay","Zenath","Kavitha","Ajay","Bhumi")));
//		System.out.println("Vector is : \n" + v1);
//		removeDuplicateFromVector(v1);
		
		// Question 13 -> Create a vector of 10 names, Print duplicates from it.
//		getDuplicateFromVector(v1);

		// Question 4 -> From the group of 10 Students (roll_num, name & Marks), Print student of first 3 ranks. 
		ArrayList<Student> listStud = new ArrayList<>(Arrays.asList(
				new Student(1, "Sangeeta", 80),new Student(2, "Manoj", 86),
				new Student(3, "Ankita", 45),new Student(4, "Pallavi", 66),
				new Student(5, "Ramesh", 98),new Student(6, "Aniket", 75),
				new Student(7, "Prabhas", 80),new Student(8, "Arjun", 37),
				new Student(9, "Priya", 83),new Student(10, "Sakshi", 77)
				));
		
		System.out.println("Student list is : " + listStud);
		studentsFirst3Rank(listStud);
		
	}

	private static void studentsFirst3Rank(ArrayList<Student> listStud) {
		Collections.sort(listStud,	new MarksComparator());
		System.out.println(listStud.subList(0, 3));
	}

	private static void getDuplicateFromVector(Vector<String> v1) {
		System.out.println("Duplicates in Vector v1 : ");		
		HashSet<String> set1 = new HashSet<>();
		for (String str : v1) {
			if (set1.add(str) == false) {
				System.out.println(str);
			}
		}
		
	}

	private static void removeDuplicateFromVector(Vector<String> v1) {
		
		HashSet<String> set1 = new HashSet<>(v1);
		ArrayList<String> l1 = new ArrayList<>(set1); 
		
		// 1st Way --->
//		Collections.sort(l1);
//		Collections.reverse(l1);
//		System.out.println("Removing duplicates & arranging in reverse dictionary order : \n" + l1);
				
		// 2nd Way --->
//		Comparator<String> c1 = Collections.reverseOrder();
//		Collections.sort(l1, c1);
//		System.out.println("Removing duplicates & arranging in reverse dictionary order : \n" + l1);
		
		/// 3rd Way --->
		TreeSet<String> set2 = new TreeSet<>(new TreeSet<>(v1).descendingSet());
		System.out.println("Removing duplicates & arranging in reverse dictionary order : \n" + set2);
		
	}

	private static void sortListUsingIncrement(ArrayList<Employee> l2) {
		Iterator<Employee> itr = l2.iterator();
		while (itr.hasNext()) {
			Employee employee = (Employee) itr.next();
			if (employee.empIncrement < 11) {
			// if (employee.empIncrement < 11 && employee.empName.length() > 7) {
			// Above condition will return increment is higher than 10 & length of empName is less than 7
				itr.remove();
			}
		}
		System.out.println("Employees which are having increment greater than 10 are : \n"
				+ l2);
	}

	private static void removeStringsUsingEnumeration(ArrayList<String> l1) {
		Vector<String> v1 = new Vector<>(l1);
		Enumeration<String> en = v1.elements();
		
		while (en.hasMoreElements()) {
			String str = en.nextElement();
			if (str.startsWith("K") || str.startsWith("k")) {
				v1.remove(str);
			}
		}
		System.out.println("List after removing String which starts with K & k : "
				 + "Using removeStringsUsingEnumeration() Method :\n" + l1);
	}

	private static void removeStringsUsingListIterator(ArrayList<String> l1) {
		ListIterator<String> itr = l1.listIterator();
		while (itr.hasNext()) {
			String str = itr.next();
			if (str.startsWith("K") || str.startsWith("k")) {
				itr.remove();
			}
		}
		System.out.println("List after removing String which starts with K & k : "
				+ "Using removeStringsUsingListIterator() Method :\n" + l1);
	}
	
}