package bitManipulation;

public class IntToBinary {
	
	static String int2Binary(int n) {
		String s = "";
		while(n > 0) {
			String bit;
			if(n%2 == 0) {
				bit = "0";
			} else {
				bit = "1";
			}
			
			s = s + bit;
			n = n/2;
		}
		return s;
	}
	
	public static void main(String args[]) {
		int n = 7;
		System.out.print("Binary Output of " + n +" is: " + int2Binary(n));
	}

}
