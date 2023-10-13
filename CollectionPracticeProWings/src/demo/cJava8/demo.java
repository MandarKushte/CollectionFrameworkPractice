package demo.cJava8;

import java.util.HashMap;
import java.util.Map;

public class demo {

	public static void main(String[] args) {
		
		Map<Integer, Integer> map1 = new HashMap<>();
		map1.put(1, 200);map1.put(2, 100);map1.put(3,  500);map1.put(4, 800);map1.put(5, 1000);
		map1.put(6, 300);map1.put(7, 400);map1.put(8, 700);map1.put(9, 600);map1.put(10, 900);
		
		System.out.println(map1);
		
	}

}