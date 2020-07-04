package bitManipulation;

public class PowerofTwo {
	
	static boolean isPowerofTwo(int n) {
		if(n == 0) {
			return false;
		}
		while(n != 1) {
			if(n%2 != 0) {
				return false;
			} 
			n = n/2;
		}
		
		return true;
	}
	
	 //return 1 if true and 0 if not
	static boolean  isPowerofTwo_(int num) {
		if(num == 0) {
			return false;
		}
		
		if((num & (num - 1)) == 0) {
			return true;
		} 
		
		return false;
	}
	
	public static void main(String args[]) {
		int num = 64;
		
		System.out.println(isPowerofTwo_(num));
	}

}
