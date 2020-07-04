package stringManipulation;

/**write a program that checks if two strings are anagrams of each other
 * 
 * pseudocode:
 * 1. if length of string 1 is different from length of string 2 the two strings are not anagrams
 * 2. else if lengths are the same:
 * 3. 		check if each characters of string 1 is in string 2
 * 4. 		if any character in one of the strings is not in the other, then the two strings are not anagrams
 * **/

public class Anagram {
	static boolean anagramCheck(String s1, String s2) {
		if(s1.length() != s2.length()) {
			return false;
		} else {
			char c1[] = s1.toCharArray();
			char c2[] = s2.toCharArray();
			for(int i = 0; i<c1.length; i++) {
				if (!String.valueOf(c2).contains(Character.toString(c1[i]))) {
					return false;
				}
			}
			return true;
		}
	}
		
	public static void main(String args[]) {
		String s1 = "fried";
		String s2 = "fired";
		
		System.out.print(anagramCheck(s1, s2));
	}
}
