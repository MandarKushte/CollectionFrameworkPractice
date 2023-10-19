package demo.cJava8;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class demo2 {

	public static void main(String[] args) {
		
		int[] arr = {10,20,30,70,50,10,80,20,60,100};
		System.out.println("Array arr is : " + Arrays.toString(arr));
		List<Integer> l1 = Arrays.stream(arr).mapToObj(Integer::valueOf).collect(Collectors.toList());
		System.out.println("List l1 : " + l1);
		
		System.out.println("Duplicates : " + 
			l1.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).
			entrySet().stream().filter(m->m.getValue()>1).map(Map.Entry::getKey).
			collect(Collectors.toList())
				);
		
		System.out.println("Number from 1 " + 
			l1.stream().map(m->m+"").filter(i->i.startsWith("1")).collect(Collectors.toList())
				);
		
		
		
		
	}
}