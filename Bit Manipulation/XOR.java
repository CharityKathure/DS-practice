package bitManipulation;

public class XOR {
	//we get 0 as XOR value just before every multiple of 4
	/*num   binary    XOR
	 * 1 --- 1    --- 0001
	 * 2 --- 10   --- 0011
	 * 3 --- 11   --- 0000
	 * 4 --- 100  --- 0100
	 * 5 --- 101  --- 0001
	 * 6 --- 110  --- 0111
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
	
	static int xorArray(int arr[]) {
		
		int arrXOR = 0;
		for(int i = 0; i<arr.length; i++) {
			arrXOR = arrXOR ^ arr[i];
		}
		
		return arrXOR;
	}
	
	static void printArray(int arr[]){
		for(int i = 0; i< arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
	
	public static void main(String args[]) {
		int num = 7;
		System.out.println("XOR of " + num + ": " + xor(num));
		
		System.out.print("\n");
		int arr[] = { 3, 9, 12, 13, 15 }; 
		System.out.print("XOR of ");
		printArray(arr);
		System.out.print(" : " + xorArray(arr));
		
	}

}
