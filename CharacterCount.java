package practice13022020;

import java.util.*;

/*string S = “ababcd”*/

public class CharacterCount {
	
	static void stringCount(String s) {
		
		Hashtable<Character, Integer> mapping = new Hashtable<Character, Integer>();
		for(int i=0; i<s.length(); i++) {
			char curr = s.charAt(i);
			
			if(!mapping.containsKey(curr)) {
				mapping.put(curr, 1);
			} else {
				mapping.put(curr, mapping.get(curr)+1);
			}
		}

		System.out.println(mapping);
	}
	
	static void printHashTableValues(Hashtable<Character, Integer> mapping) {
		Enumeration e = mapping.elements();
		
		while(e.hasMoreElements()) {
			System.out.println(e.nextElement());
		}
	}
	
	static void printDistinctCharacters(Hashtable<Character, Integer> mapping) {
		Enumeration e = mapping.keys();
		
		while(e.hasMoreElements()) {
			System.out.println(e.nextElement());
		}
	}
	
	public static void main(String[] args) {
		
		String s = "ababcd";
		stringCount(s);
		
		
	}
	
}
