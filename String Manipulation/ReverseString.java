package stringManipulation;

import java.util.Stack;

/**reverse a given string in place**/
public class ReverseString {
	//Idea: use a structure that supports last in First out, to aid in reversal.
	
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
	
	public static void main(String args[]) {
		String s = "String";
		
		String rs = reverseStringInPlace(s);
		System.out.print("Reversed: " + rs);
		
		
	}

}
