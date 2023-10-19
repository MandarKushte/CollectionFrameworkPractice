package demo.cJava8;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class demo {

	public static void main(String[] args) {
		int[] arr = {10,20,30,70,50,10,80,20,60,100};
		// IMP
		List<Integer> l1 = Arrays.stream(arr).mapToObj(Integer::valueOf).collect(Collectors.toList());
		System.out.println("Array arr : " + Arrays.toString(arr));
		System.out.println("List l1 : " + l1);
		
		// IMP
		System.out.println("Duplicates in arr are : " + 
				l1.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting())).
				entrySet().stream().filter(m->m.getValue()>1).map(Map.Entry::getKey).collect(Collectors.toList())
				);
		
		// IMP
		System.out.println("Numbers starting from 1 are :" + 
			l1.stream().map(s->s+"").filter(i->i.startsWith("1")).collect(Collectors.toList())
				);
		
		//IMP
		//Q11 --> Find the length of longest string from String Array.
		String[] strArr = {"Mandar","Rahul","Aniket","ChandraKala","Netanyahu","Putin"};
 		System.out.println("String Array is : " + Arrays.toString(strArr));
 		System.out.println("Longest string in Array of String is : " +
 			Arrays.stream(strArr).mapToInt(String::length).max().orElse(0)
 				);
		
 		System.out.println("Duplicates removed from list l1 : "+
 				l1.stream().distinct().collect(Collectors.toList())
 				);
 		
 		System.out.println("Sorted list without duplicates : " +
 				l1.stream().distinct().sorted().collect(Collectors.toList())
 				);
 		
 		System.out.println("Reverse Sorted List without duplicates is : " + 
 				l1.stream().distinct().sorted(Collections.reverseOrder()).collect(Collectors.toList())
 				);
 		
 		System.out.println("Smallest element in arr is : " + 
 				l1.stream().distinct().sorted().skip(0).findFirst().get()
 				);
 		
 		System.out.println("Largest element in arr is : " + 
 				l1.stream().distinct().sorted(Collections.reverseOrder()).skip(0).findFirst().get()
 				);
 		
 		System.out.println("Second Smallest element in arr is : " + 
 				l1.stream().distinct().sorted().skip(1).findFirst().get()
 				);
 		
 		System.out.println("Elements greater than 20 are : " +
 				l1.stream().filter(n->n>20).collect(Collectors.toList())
 				);
 		
 		System.out.println("Elements less than 20 are : " +
 				l1.stream().filter(n->n<20).collect(Collectors.toList())
 				);
		
		
		
		
		
	}
}