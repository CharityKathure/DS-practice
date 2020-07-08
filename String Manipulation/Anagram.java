package stringManipulation;

import java.util.Arrays;
import java.util.Hashtable;

/**write a program that checks if two strings are anagrams of each other
 * 
 * pseudocode:
 * 1. Remove spaces from both strings
 * 2. if length of string 1 is different from length of string 2 the two strings are not anagrams
 * 3. else if lengths are the same:
 * 4. 		check if each characters of string 1 is in string 2
 * 5. 		check if each character of string 2 is in string 2
 * 6. 		if any character in one of the strings is not in the other, then the two strings are not anagrams		
 * **/

public class Anagram {
	static boolean anagramCheck(String s1, String s2) {
		s1 = s1.replaceAll("\\s+","").toUpperCase();
		s2 = s2.replaceAll("\\s+","").toUpperCase();
		
		if(s1.length() != s2.length()) {
			return false;
		} else {
			char c1[] = s1.toCharArray();
			for(int i = 0; i<c1.length; i++) {
				if (!s2.contains(Character.toString(c1[i]))) {
					return false;
				}
			}
			
			char c2[] = s2.toCharArray();
			for(int i = 0; i<c2.length; i++) {
				if (!s1.contains(Character.toString(c2[i]))) {
					return false;
				}
			}
			return true;
		}
	}
	
	static boolean anagram(String s1, String s2) {
		s1 = s1.replaceAll("\\s+","").toUpperCase();
		s2 = s2.replaceAll("\\s+","").toUpperCase();
		
		if(s1.length() != s2.length()) {
			return false;
		}
		
		char[] s1CharArray = s1.toCharArray();
		char[] s2CharArray = s2.toCharArray();
		
		Arrays.sort(s1CharArray);
		Arrays.sort(s2CharArray);
		
		if(!Arrays.equals(s1CharArray, s2CharArray)) {
			return false;
		}
		
		return true;
	}
	
	static boolean anagramUsingHashTable(String s1, String s2) {
		s1 = s1.replaceAll("\\s+","").toUpperCase();
		s2 = s2.replaceAll("\\s+","").toUpperCase();
		
		if(s1.length() != s2.length()) {
			return false;
		}
		
		Hashtable<Character, Integer> h1 = new Hashtable<>();
		for(int i=0; i<s1.length(); i++) {
			if(!h1.containsKey(s1.charAt(i))) {
				h1.put(s1.charAt(i), 1);
			} else {
				int charCount = h1.get(s1.charAt(i));
				h1.put(s1.charAt(i), charCount+1);
			}
		}
		
		Hashtable<Character, Integer> h2 = new Hashtable<>();
		for(int i=0; i<s2.length(); i++) {
			if(!h2.containsKey(s2.charAt(i))) {
				h2.put(s2.charAt(i), 1);
			} else {
				int charCount = h2.get(s2.charAt(i));
				h2.put(s2.charAt(i), charCount+1);
			}
		}
		if(!h1.equals(h2)) {
			return false;
		}
		
		return true;
	}
		
	public static void main(String args[]) {
		String s1 = " Dormito ry";
		String s2 = "dirty room";
		
		System.out.print(anagramUsingHashTable(s1, s2));
	}
}
