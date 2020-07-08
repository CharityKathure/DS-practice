package stringManipulation;

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
		
	public static void main(String args[]) {
		String s1 = "Dormitory";
		String s2 = "Dirty room";
		
		System.out.print(anagramCheck(s1, s2));
	}
}
