package stringManipulation;

public class Palindrome {
	
	static boolean palindrome(String s) {
		/*1. rotate string 2. check if string is equal to original string*/
		s = s.replaceAll(" ", "").toUpperCase();
		
		char[] c = s.toCharArray();
		int l = 0;
		int r = s.length() - 1;
		for(l=0; l<r; l++, r--) {
			char temp = c[r];
			c[r] = c[l];
			c[l] = temp;
		}
		
		if(s.equals(new String(c))) {
			return true;
		} else {
			return false;
		}
	}
	
	static String longestPalindrome(String s) {
		/*Given a string, find the longest substring which is palindrome.*/
		String longestPalindrome = "";
		for(int i=0; i<=s.length(); i++) {
			for(int j=i; j<=s.length(); j++) {
				String sub = s.substring(i, j);
				if(palindrome(sub) && longestPalindrome.length() < sub.length()) {
					longestPalindrome = sub;
				}
			}
		}
		
		return longestPalindrome;
	}
	
	public static void main(String args[]) {
		String s = "forgeeksskeegfor";
		System.out.println(longestPalindrome(s));
	}
	

}
