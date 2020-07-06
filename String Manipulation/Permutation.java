package stringManipulation;

import java.util.ArrayList;

public class Permutation {
	
	static ArrayList<String> permutation(String s){
		
		ArrayList<String> al = new ArrayList<>();
		int count = 3;
		for(int i = 0; i < s.length()-1; i++) {
			System.out.print(count + ": ");
			String str = s;
			for(int j=i; j < s.length(); j++) {
					
					s = swapCharacters(str, i, j);
					System.out.print(s + " ");
					
					if(!al.contains(s)) {
						al.add(s);
					}
				
				count++;
			}
			
			System.out.print("\n");	
		}
		
		return al;
	}
	
	
	
	static String swapCharacters(String s, int i, int j) {
		char[] c = s.toCharArray();
		char temp = c[i];
		c[i] = c[j];
		c[j] = temp;
		
		s = String.valueOf(c);
		
		return s;
	}
	
	

	public static void main(String args[]) {
		String s = "ABC";
		System.out.println(permutation(s));
	}
}
