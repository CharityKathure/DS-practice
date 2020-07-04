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
	
	 
	static boolean  isPowerofTwo_(int num) {
		/*num is a power of 2 if and only if num (in binary representation) 
		and(&) num - 1(in binary representation)
		is zero*/
		
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
