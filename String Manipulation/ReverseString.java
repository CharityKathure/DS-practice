package stringManipulation;

import java.util.Stack;

/**reverse a given string in place**/
public class ReverseString {
	
	//1st Method: using character array
		static String reverseString(String s) {
			StringBuffer str = new StringBuffer();
			char c[] = s.toCharArray();
			for(int i=s.length()-1; i>=0; i--) {
				str.append(c[i]);
			}
			return str.toString();
		}
	
	
	//2nd Method: use a structure that supports last in First out, to aid in reversal.
	static String reverseStringInPlace(String s) {
		Stack<Character> stack = new Stack<>();
		
		//Populate Stack with String characters
		for(int i=0; i<s.length(); i++) {
			char curr = s.charAt(i);
			stack.add(curr);
		}
		
		//create the reversed string by popping the characters in the stack.
		String str = "";
		while(!stack.isEmpty()) {
			str = str + stack.peek();
			stack.pop();
		}
		
		return str;
	}
	
	//3rd Method:O(log n), using array of characters, have one point on the right most char, and another on the left most,
	//swap characters and decrement and increment pointer location respectively until left is less than or equal to right
	static String reverseStringPtrs(String s) {
		
		char c[] = s.toCharArray();
		int l = 0;
		int r = c.length - 1;
		
		for(l=0; l<r; l++, r--) {
			//swap
			char temp = c[r];
			c[r] = c[l];
			c[l] = temp;
		}
		
		
		StringBuilder str = new StringBuilder();
		for(int i=0; i< c.length; i++) {
			str.append(c[i]);
		}
		
		return str.toString();
	}
	
	
	public static void main(String args[]) {
		String s = "Valentino Shimanyula";
		
		String rs = reverseStringPtrs(s);
		//String rs = reverseString(s);
		//String rs = reverseStringInPlace(s);
		
		System.out.print("Reversed: " + rs);
		
		
	}

}
