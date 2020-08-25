package postEntry;

import java.util.ArrayList;

public class StringAandBSequence {
	static int minimumDelete(String inputStr) {
		
		ArrayList<Character> sortedStringChars = new ArrayList<>();
		
		int count = 0;
		int lstA = -1;
		
		//get the last position of A
		for(int i = 0; i<inputStr.length(); i++) {
			if(inputStr.charAt(i) == 'A') {
				lstA = i;
			}
		}
		
		//get all B's before the last A
		for(int i = 0; i<inputStr.length(); i++) {
			if(inputStr.charAt(i) == 'B' && i<lstA) {
				count++;
			} else {
				sortedStringChars.add(inputStr.charAt(i));
			}
		}
		
		System.out.print(sortedStringChars);
		System.out.print('\n');
		System.out.print('\n');
		
		return count;
	}
	public static void main(String[] args) {
		//String inputStr = "BAAABAB"; 
		//String inputStr = "BBABAA";
		String inputStr = "AABBBB";
		
		System.out.println("To be deleted: " + minimumDelete(inputStr) + " time(s)");
	}

}
