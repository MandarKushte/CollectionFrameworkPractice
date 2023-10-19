package demo.cJava8;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

//Q1 ---> Ascending & Discending Sorting array using Stream Interface.
//Q2 ---> Find Occurence of each array element numbers. -1.using HashMap, 2.using JAVA8
//Q4 --> Printing elements which are greater than 20.
//Q5 --> Printing count of elements which are greater than 20.
//Q7 --> Printing Maximum & element in Array.
//Q8 --> Fetching second smallest element in Array.
//Q8.2 --> Fetching second largest element in Array.

// ***** IMP
//Q3 ---> Find duplicate numbers.
//Q6 --> Find All the numbers from list of Integer starting with 1.
//Q9 --> Find common elements of two arrays.
//Q10 --> Reverse an array of integer in-place.
//Q11 --> Find the length of longest string from String Array.

public class aMainClass {

	public static void main(String[] args) {
		//Q1 ---> Ascending & Discending Sorting array using Stream Interface.
		int[] arr = new int[10];
		arr[0]=10;arr[1]=20;arr[2]=90;arr[3]=50;arr[4]=70;
		arr[5]=100;arr[6]=90;arr[7]=70;arr[8]=50;arr[9]=30;
		System.out.println("Array is : " + Arrays.toString(arr));
		
		// Converting Array into List --->
		List<Integer> list =  Arrays.stream(arr).mapToObj(Integer::valueOf).collect(Collectors.toList());
		
		System.out.println("Ascending Sorting Array with Duplicates is : ");
		System.out.println(
				list.stream().sorted().collect(Collectors.toList())
				);
		
		System.out.println("Ascending Sorting Array without Duplicates is : ");
		System.out.println(
				list.stream().distinct().sorted().collect(Collectors.toList())
				);
		
		System.out.println("Descending Sorting Array with Duplicates is : ");
		System.out.println(
				list.stream().sorted(Collections.reverseOrder()).collect(Collectors.toList())
				);
		
		System.out.println("Descending Sorting Array without Duplicates is : ");
		System.out.println(
				list.stream().distinct().sorted(Comparator.reverseOrder()).collect(Collectors.toList())
				);
		
		//Q2 ---> Find Occurence of each array element numbers. -1.using HashMap, 2.using JAVA8
		// Using HashMap --->
		System.out.println("\nList 1 : " + list);
		Map<Integer, Integer> map1 =  new LinkedHashMap<>();
		for (Integer i1 : list) {
			map1.put(i1, map1.containsKey(i1) ? map1.get(i1)+1 : 1);
		}
		System.out.println("Occurence of each array element :\n" + map1);
		
		// Using JAVA8 --->
		System.out.println("Occurence of each array element :\n" + 
			list.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
				);
		
		// Q3 ---> Find duplicate numbers.
		System.out.println("Duplicates in List is : " +
			list.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).
			entrySet().stream().filter(m->m.getValue()>1).map(Map.Entry::getKey).collect(Collectors.toSet())
				);
	
		// Q4 --> Printing elements which are greater than 20 --->
		System.out.println("Elements greater than 20 : " +
			list.stream().distinct().filter(n-> n>20).collect(Collectors.toList())
				);
		// Q5 --> Printing counts of elements which are greater than 20 --->
		System.out.println("Elements greater than 20 : " +
			list.stream().distinct().filter(n-> n>20).collect(Collectors.counting())
				);
		
		//Q6 --> Find All the numbers from list of Integer starting with 1.
		System.out.println("Numbers which are starting from 1 : " +
			list.stream().distinct().map(s->s + "").filter(i->i.startsWith("1")).collect(Collectors.toList())
				);
		
		//Q7 --> Printing Maximum & element in Array.
		System.out.println(	"Maximum element in Array is : " +
			list.stream().max(Integer::compare).get()		+
							"\nMinimum element in Array is : " +
			list.stream().min(Integer::compare).get()
				);
		
		//Q8 --> Fetching second smallest element in Array.
		System.out.println("Second smallest element in Array is : " +
			list.stream().sorted().distinct().skip(1).findFirst().orElseThrow(
					() -> new IllegalArgumentException("Array doesnot have a second lowest element"))
				);
		
		//Q8.2 --> Fetching second largest element in Array.
		System.out.println("Second smallest element in Array is : " +
			list.stream().sorted(Comparator.reverseOrder()).distinct().skip(1).findFirst().orElseThrow(
					() -> new IllegalArgumentException("Array doesnot have a second largest element"))	
				);
		
		//Q9 --> Find common elements of two arrays.
		int[] arr1 = {1,2,3,4,5,6};int[] arr2 = {5,6,7,8};
		System.out.println("\nArr1 : " + Arrays.toString(arr1));
		System.out.println("Arr2 : " + Arrays.toString(arr2));
		System.out.print("Common Elements in Array1 & Array2 are : ");
		List<Integer> commonElements = 	Arrays.stream(arr1).
			filter(number -> Arrays.stream(arr2).anyMatch(arr2Number -> arr2Number==number)).
			boxed().collect(Collectors.toList());
		System.out.println(commonElements);
		
		//Q10 --> Reverse an array of integer in-place.
		
		//Q11 --> Find the length of longest string from String Array.
		String[] strArr = {"Mandar","Rahul","Aniket","ChandraKala","Netanyahu","Putin"};
 		System.out.println(Arrays.toString(strArr));
 		System.out.println("Largest length of String in String Array is : " +
 			Arrays.stream(strArr).mapToInt(String::length).max().orElse(0) 			
 				);
		
	}
	
	
}