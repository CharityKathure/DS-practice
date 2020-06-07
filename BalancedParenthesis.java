
package stacks;

import java.util.Stack;
/* Given an expression string exp, 
 * write a program to examine whether the pairs and the orders of “{“,”}”,”(“,”)”,”[“,”]” are correct*/

public class BalancedParenthesis {
	static boolean isMatching(char c1, char c2) {
		if(c1 == '{' && c2 == '}') {
			return true;
		} else if(c1 == '(' && c2 == ')') {
			return true;
		} else if(c1 == '[' && c2 == ']') {
			return true;
		} else {
			return false;
		}
	}
	
	
	static boolean isBalanced(char pars[]) {
		Stack<Character> s = new Stack<>();
		for(int i=0; i<pars.length; i++) {
			if(pars[i] == '{' || pars[i] == '[' || pars[i] == '(') {
				s.push(pars[i]);
			}
			if(pars[i] == '}' || pars[i] == ']' || pars[i] == ')') {
				if(s.isEmpty()) {
					return false;
				}
				if(!isMatching(s.pop(), pars[i])) {
					return false;
				}
				
			}
		}
		if(s.isEmpty()) {
			return true; /*balanced*/
		} else {
			return false; /*not balanced*/
		}
	}
	
	public static void main(String args[]) {
		
		char pars[] = {'{','(',')','}','[',']'};
		
		System.out.print(isBalanced(pars));
		
	}

}
