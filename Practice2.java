package practice13022020;

import java.util.*;

/*
 * Spreadsheets often use this alphabetical encoding for its columns: 
 * "A", "B", "C", ..., "AA", "AB", ..., "ZZ", "AAA", "AAB", ....
 * Given a column number, return its alphabetical column id. For example, 
 * given 1, return "A". Given 27, return "AA".
 */

public class Practice2 {
	
	static String excelConvert(Hashtable<Integer, Character> h, int n) {
		if(n<=1) {
			return "";
		}
		
		int completeCycles = n/26;
		int remainder = n%26;
		
		String finalString ="";
		for(int i=0; i<completeCycles; i++) {
			String append = "A";
			finalString = finalString + append;
		}
		
		if(remainder != 0) {
			char y = h.get(remainder);
			finalString = finalString + y;
		}
		
		return finalString;
	}
	
	static Hashtable<Integer, Character> createHash(){
		Hashtable<Integer, Character> h = new<Integer, Character> Hashtable();
		
		char[] alphabet = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
		
		for(int i=0; i<alphabet.length; i++){
			h.put(i+1, alphabet[i]);
		}
		
		return h;
	}
	

	public static void main(String[] args) {
		
		//alphabet mapping//
		Hashtable<Integer, Character> h = createHash();
		
		
		int num = 51;
		
		String output = excelConvert(h, num);
		
		System.out.println(output);
	}
}
