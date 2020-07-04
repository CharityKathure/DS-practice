package bitManipulation;

public class XOR {
	//we get 0 as XOR value just before every multiple of 4
	/*num   binary    XOR
	 * 1 --- 1    --- 0001
	 * 2 --- 10   --- 0010
	 * 3 --- 11   --- 0000
	 * 4 --- 100  --- 0100
	 * 5 --- 101  --- 0101
	 * 6 --- 110  --- 0110
	 * 7 --- 111  --- 0000
	 * 8 --- 1000 --- 1000
	 */
	
	static int xor(int n) {
		
		int rem = n % 4;
		
		if(rem == 0) {
			return n; 
		} 
		if(rem == 1) {
			return 1;
		}
		if(rem == 2) {
			return n + 1;
		}
		
		return 0;
	}
	
	public static void main(String args[]) {
		int num = 7;
		System.out.println(xor(num));
	}

}
