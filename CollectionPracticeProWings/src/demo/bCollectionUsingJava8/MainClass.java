package demo.bCollectionUsingJava8;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class MainClass {
	
	public static void main(String[] args) {
		
		Map<String, Integer> salaries = new HashMap<String, Integer>();
		salaries.put("John", 40000);
		salaries.put("Freddy", 30000);
		salaries.put("Samuel", 50000);

		// Two-Arity Function Specializations --->
		System.out.println("----------------------	Two-Arity Function Specializations	-------------------");
		salaries.replaceAll(
			(name, oldValue) ->name.equals("Freddy") ? oldValue : oldValue + 10000);
		System.out.println("Salaries : " + salaries);
		
		Integer value1 = salaries.computeIfAbsent("Freddy", s -> s.length());
		System.out.println(value1);
		
		Integer value2 = salaries.computeIfAbsent("John", String::length);
		System.out.println(value2);
		
		System.out.println("------------------------------- Function -------------------------------");
		Function<Integer, String> intToString = Object::toString;
		Function<String, String> quote = s -> "'" + s + "'";
		Function<Integer, String> quoteIntToString = quote.compose(intToString);
		System.out.println(quoteIntToString.apply(5));
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}