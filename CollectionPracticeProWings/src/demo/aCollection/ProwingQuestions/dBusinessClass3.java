package demo.aCollection.ProwingQuestions;
//Questions -> 14,15,17 
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class Player{
	int playerId;
	String fname;
	String lname;
	public Player(int playerId, String fname, String lname) {
		super();
		this.playerId = playerId;
		this.fname = fname;
		this.lname = lname;
	}
	@Override
	public String toString() {
		return "\nplayerId=" + playerId + ", fname=" + fname + ", lname=" + lname + "]";
	}
}

class lnameCompare implements Comparator<Player>{
	@Override
	public int compare(Player o1, Player o2) {
		return o1.lname.compareTo(o2.lname);
	}
}

class fnameCompare implements Comparator<Player>{
	@Override
	public int compare(Player o1, Player o2) {
		return o1.fname.compareTo(o2.fname);
	}
}

public class dBusinessClass3 {

	public static void main(String[] args) {

		// 14.Take a list of players and sort by last name ->
		//	  1)take fname & lname two variables
//		ArrayList<Player> l1 = new ArrayList<>(Arrays.asList( new Player(1, "John", "Mantos"), 
//				new Player(2, "Sachin", "Tendulkar"), new Player(3, "Saurav", "Ganguly"), 
//				new Player(4, "Mahendra", "Dhoni"),new Player(5, "Rushi", "Agarkar")));
//		sortByLastName(l1);
//		sortByFirstName(l1);
		
		//	  2) take single full name with fname & lname.
//		List<String> l2 = new ArrayList<>(Arrays.asList("Virat Kohli","Yuvraj Singh","MS Dhoni",
//				"Kunal Pandya","Hardik Pandya","KL Rahul"));
//		sortByLastNameCombineName(l2);
		
		// 15.Find key in HashMap against given value ->
//		LinkedHashMap<String, String> hm = new LinkedHashMap<>();
//		hm.put("City", "Green");
//		hm.put("800", "Red");
//		hm.put("Seltos", "Blue");
//		hm.put("EECO", "White");
//		hm.put("Tavera", "Black");
//		hm.put("Esteem", "Red");
//		hm.put("Alto", "Green");
//		
//		String value = "Black";
//		getKeyAgaintsValue(hm, value);
		
		// 17.Find common in 2 sets ->
		Set<Integer> set1 = new LinkedHashSet<>();
		set1.add(1);set1.add(2);set1.add(3);set1.add(4);set1.add(5);
		Set<Integer> set2 = new LinkedHashSet<>();
		set2.add(3);set2.add(4);set2.add(6);
		
		Set<Integer> commonSet = new LinkedHashSet<>(set1);
		commonSet.retainAll(set2);
		System.out.println("Set1 is : " + set1);
		System.out.println("Set2 is : " + set2);
		System.out.println("commonSet : " + commonSet);
		
	}

	private static void getKeyAgaintsValue(LinkedHashMap<String, String> hm, String value) {
		System.out.println(hm);
		System.out.println("Value is : " + value);
		if (hm.containsValue(value)) {
			for(Entry<String, String> entry : hm.entrySet()) {
				if(entry.getValue().equals(value)) {
					System.out.println("Key against value " + value + ", is : " + entry.getKey() );
				}
			}
		}
		else {
			System.out.println("Value : " + value + " is not present in HashMap...");
		}
	}

	private static void sortByLastNameCombineName(List<String> l2) {
		System.out.println("Original List : ");
		for (String string : l2) {
			System.out.println(string);
		}
		
		Comparator<String> comp = new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				String x = o1.toString();
				String y = o2.toString();
				
				String[] Arr1 = x.split(" ");
				String[] Arr2 = y.split(" ");
				
				if (Arr1[1].equals(Arr2[1])) {
					return Arr1[0].compareTo(Arr2[0]);
				}
				return Arr1[1].compareTo(Arr2[1]);
			}
		};
		
		Collections.sort(l2,comp);
		System.out.println("Sorted by Last Name : " + l2);
		
		
	}

	private static void sortByLastName(ArrayList<Player> l1) {
		System.out.println("Original List : " + l1);
		Collections.sort(l1, new lnameCompare());
		System.out.println("\nSorted by Last name, Then List is : " + l1);
	}
	
	private static void sortByFirstName(ArrayList<Player> l1) {
		System.out.println("Original List : " + l1);
		Collections.sort(l1, new fnameCompare());
		System.out.println("\nSorted by First name, Then List is : " + l1);
	}
}