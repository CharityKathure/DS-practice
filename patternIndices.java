package practice13022020;

/*
 * Given a string and a pattern, find the starting indices of all occurrences of the pattern in the string. 
 * For example, given the string "abracadabra" and the pattern "abr", you should return [0, 7].
 */
import java.util.ArrayList;

public class patternIndices {
static ArrayList<Integer> findIndices(String s, String f) {
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		int length = s.length();
		int start = 0;
		for(int i = 0; i < length; i++) {
			//string being checked currently//
			String currString = s.substring(start, length);
			
			//if the length from current character to the end of the string is less 
			//than length of string to find, then it doesn't match.. no need of checking
			if(currString.length() >= f.length()) {
				String curr = currString.substring(0, f.length());
				if(curr.equals(f)) {
					list.add(start);
				}
			}
			//increment start to check from next character onwards
			start++;
		}
		return list;
	}
	
	public static void main(String[] args) {
		String input = "abracadabra";
		String find = "abr";
		
		ArrayList<Integer> indices = findIndices(input, find);
		
		System.out.print(indices.toString());
	}
}
