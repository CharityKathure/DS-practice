package stringManipulation;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class DuplicatedCharacters {
	
	static ArrayList duplicatedChars(String s) {
		ArrayList<Character> l = new ArrayList<>();
		Hashtable<Character, Integer> h = new Hashtable<>();
		for(int i=0; i<s.length(); i++) {
			if(h.containsKey(s.charAt(i))) {
				h.put(s.charAt(i), h.get(s.charAt(i)) + 1);
				
			} else {
				h.put(s.charAt(i), 1);
			}
		}
		
		
		
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
	
	public static void main(String args[]) {
		String s = "potato";
		System.out.println(duplicatedChars(s));
		
	}

}
