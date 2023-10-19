package demo.aCollection.ProwingQuestions;
//Questions -> 6,7,8,9,10,11

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class cBusinessClass2 {
	
	public static void main(String[] args) {
		// Q6 From a HashMap of < Vehicle Model & Vehicle Color >.
		// 	  Remove vehicle of green & red color.
//		LinkedHashMap<String, String> hm = new LinkedHashMap<>();
//		hm.put("City", "Green");
//		hm.put("800", "Red");
//		hm.put("Seltos", "Blue");
//		hm.put("EECO", "White");
//		hm.put("Tavera", "Black");
//		hm.put("Esteem", "Red");
//		hm.put("Alto", "Green");
//		System.out.println("LinkedHashMap is : " + hm);
		
		// Printing Hashmap Using EntrySet
//		System.out.println("Printing LinkedHashMap using EntrySet : ");
//		for (Map.Entry<String, String> entry : hm.entrySet()) {
//			System.out.println(entry.getKey() + ": " + entry.getValue());
//		}
	
//		removeColor(hm,"Green","Red");
//		System.out.println(hm);
		
		// Q7 From a HashMap of < Name & Scores >.Remove scores less than 50.
//		LinkedHashMap<String, Integer> nameScore = new LinkedHashMap<>();
//		nameScore.put("Manish", 35);
//		nameScore.put("Onkar", 40);
//		nameScore.put("Mandar", 45);
//		nameScore.put("Rahul", 50);
//		nameScore.put("Sohel", 51);
//		nameScore.put("Pradnya", 60);
//		nameScore.put("Aniket", 90);
//		System.out.println("Name & Score HashMap : " + nameScore);
		
//		removeMarks(nameScore, 50);
//		System.out.println(nameScore);
		
		// Q8 From a HashMap of < Appraisal & Designation>.
		// Update designation as Manager, If appraisal is greater than 20%.
		
//		LinkedHashMap<Integer,String> appDesg = new LinkedHashMap<>();
//		appDesg.put(10,"Manager");		// HR,TeamLead,HR,Devloper
//		appDesg.put(30,"HR");
//		appDesg.put(25,"TeamLead");
//		appDesg.put(20,"HR");
//		appDesg.put(31,"Devloper");
//		appDesg.put(15,"Tester");
//		appDesg.put(18,"Assistant");
//		System.out.println("Apparaisal & Designation HashMap : \n" + appDesg);
//		updateDesignation(appDesg);
//		System.out.println("Updated map appDesg : \n" + appDesg);
		
		// Q9 Take A Hashmap of 6 entries, copy it into b HashMap,
		// Create 3rd HashMap with first 3 of A & last 3 of B
		
//		HashMap<Integer, String> a = new HashMap<>();
//		a.put(100, "Aniket");a.put(20, "Baburao");a.put(23, "Chetan");
//		a.put(40, "Daman");a.put(55, "Esha");a.put(36, "Farhan");
//		System.out.println("HashMap a is :\n" + a);
//		
//		HashMap<Integer, String> b = new HashMap(a);
//		System.out.println("Copied HashMap b is :\n" + b);
//
//		mergeHashMap(a,b);
		
		// Q10 Merge Two Maps Using merge() Method of HashMap.
		
//		HashMap<Integer, String> hm1 = new HashMap<>();
//		hm1.put(1, "First");hm1.put(2, "Second");hm1.put(3, "Third");
//		hm1.put(4, "Fourth");hm1.put(5, "Fifth");hm1.put(6, "Sixth");
//		
//		HashMap<Integer, String> hm2 = new HashMap<>();
//		hm2.put(5, "Fifth");hm2.put(6, "Sixth");
//		hm2.put(7, "Seven");hm2.put(8, "Eight");hm2.put(9, "Nine");
//		hm2.put(10, "Fourth");hm2.put(11, "Eleven");hm2.put(12, "Twelve");
//		
//		System.out.println("hashMap hm1 is : " + hm1);
//		System.out.println("hashMap hm2 is : " + hm2);
//		mergeHashMapUsingMergeMethod(hm1,hm2);
		
		// Q11 Frequency count of words in a sentence --->
		String sentence = "This is a sample sentence This sentence is for demonstration purposes.";
		System.out.println("Sentence is : " + sentence );
		String[] sentenceArr = sentence.split(" ");
		frequencyCountOfWords(sentenceArr);
		
	}

	private static void frequencyCountOfWords(String[] sentenceArr) {
		List<String> l1 = new ArrayList(Arrays.asList(sentenceArr));
		Map<String, Integer> map1 = new LinkedHashMap<>();
		for(String word : l1) {
			// For Case-Insensitive
//			String s1 = word.toLowerCase();
//			map1.put(s1, map1.containsKey(word)? map1.get(word)+1 : 1);
			
			// For Case-Sensitive
			map1.put(word, map1.containsKey(word)? map1.get(word)+1 : 1);
		}
		System.out.println("Frequency count of words in above sentence :\n" + map1);
	}

	private static void mergeHashMapUsingMergeMethod(HashMap<Integer, String> hm1, HashMap<Integer, String> hm2) {
		hm2.forEach((key,value)-> hm1.merge(key, value, (v1,v2) -> v2 ));
		System.out.println("Merged hashMap hm1 is : " + hm1);
	}

	private static void mergeHashMap(HashMap<Integer, String> a, HashMap<Integer, String> b) {
		HashMap<Integer, String> c = new HashMap();
		// Add first 3 of HashMap a to HashMap c --->
		int count = 0;
		for(Map.Entry<Integer, String> entry : a.entrySet()) {
			if (count<3) {
				c.put(entry.getKey(), entry.getValue());
				count++;
			}else {
				break;
			}
		}
		
		// Add last 3 of HashMap b to HashMap c --->
		count = 0;
		for(Map.Entry<Integer, String> entry : b.entrySet()) {
			if (count>=3) {
				c.put(entry.getKey(), entry.getValue());
			}else {
				count++;
			}
		}
		
		System.out.println("Merged HashMap c is :\n" + c);
	}

	private static void updateDesignation(LinkedHashMap<Integer,String> appDesg) {
		Set<Integer> set1 = appDesg.keySet();
		for(Integer x : set1) {
			if (x>=20) {
				appDesg.put(x, "Manager");
			}
		}
	}

	private static void removeMarks(LinkedHashMap<String, Integer> nameScore, Integer... marksToRemove) {
		Iterator<Map.Entry<String, Integer>> itr = nameScore.entrySet().iterator();
		
		while (itr.hasNext()) {
			Map.Entry<String, Integer> entry = (Map.Entry<String, Integer>) itr.next();
			Integer mark = entry.getValue();
			
			for(Integer mark1 : marksToRemove) {
				if(mark<mark1) {
					itr.remove();
					break;
				}
			}
		}
	}

	private static void removeColor(LinkedHashMap<String, String> hm, String... colorsToRemove) {
		Iterator<Map.Entry<String, String>> itr = hm.entrySet().iterator();
		
		while (itr.hasNext()) {
			Map.Entry<String, String> entry = itr.next();
			String color = entry.getValue();
			
			for(String colorToRemove : colorsToRemove) {
				if (color.equals(colorToRemove)) {
					itr.remove();
					break;
				}
			}
		}
	}

}