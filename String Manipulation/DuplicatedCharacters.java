package stringManipulation;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class DuplicatedCharacters {
	
	//Method 1: using Hashtable to store distinct characters and their count
	static ArrayList<Character> duplicatedChars(String s) {
		Hashtable<Character, Integer> h = new Hashtable<>();
		char c[] = s.toCharArray();
		for(int i=0; i<c.length; i++) {
			if(h.containsKey(c[i])) {
				h.put(c[i], h.get(c[i]) + 1);
				
			} else {
				h.put(c[i], 1);
			}
		}
		
		
		ArrayList<Character> l = new ArrayList<>();
		
		Iterator<Map.Entry<Character, Integer>> itr = h.entrySet().iterator();
		Entry<Character, Integer> entry = null;
		while(itr.hasNext()){
			entry = itr.next();
		    if(entry.getValue() > 1) {
		    	l.add(entry.getKey());
		    }
		}
		
		return l;
	}
	
	//Method 2: using two Arraylists, add character in arraylist 2 if character is already in arraylist 1.
	static ArrayList<Character> repeatedCharacters(String s) {
		char c[] = s.toCharArray();
		ArrayList<Character> l=new ArrayList<>();
		ArrayList<Character> l2=new ArrayList<>();
		for(int i=0; i<c.length; i++) {
			if(l.contains(c[i])) {
				l2.add(c[i]);
			}
			l.add(c[i]);
		}
		return l2;
	}
	
	//Method 3: optimization of method 2... using pointers from left and right, work your way to the middle
	static ArrayList<Character> repeatedCharactersPtrs(String s) {
		char c[] = s.toCharArray();
		ArrayList<Character> l=new ArrayList<>();
		ArrayList<Character> l2=new ArrayList<>();
		
		int left = 0;
		int right = s.length() - 1;
		for(left=0; left<right; left++, right--) {
			if(l.contains(c[left])) {
				l2.add(c[left]);
			}
			if(l.contains(c[right])) {
				l2.add(c[right]);
			}
			l.add(c[left]);
			l.add(c[right]);
		}
		return l2;
	}
	
	
	public static void main(String args[]) {
		String s = "potato";
		System.out.println(repeatedCharacters(s));
		System.out.println(repeatedCharactersPtrs(s));
		System.out.println(duplicatedChars(s));
		
	}

}
