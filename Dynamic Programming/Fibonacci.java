package dynamicProgramming;

public class Fibonacci {
	//Recursive method
	static int recuirsiveFibonacci(int n){
		if(n<=1) {
			return n;
		} else {
			return recuirsiveFibonacci(n-1) + recuirsiveFibonacci(n-2);
		}
	}
	
	static int dynamicFibonacci(int n) {
		int f[] = new int[n+1];
		f[0] = 0;
		f[1] = 1;
		for(int i=2; i<=n; i++) {
			f[i] = f[i-1] + f[i-2];
		}
		
		return f[n];
	}
	
	public static void main(String args[]) {
		int val = 6;
		
		System.out.println(recuirsiveFibonacci(val));
		System.out.println();
		System.out.println(dynamicFibonacci(val));
	}

}
