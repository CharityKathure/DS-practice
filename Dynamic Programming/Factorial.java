package dynamicProgramming;

import java.util.Hashtable;

public class Factorial {
	
	static int recursiveFactorial(int num){
		if(num <= 1) {
			return 1;
		}
		return recursiveFactorial(num-1) * num;
	}
	
	static int tabularDynamicFactorial(int num) {
		int factorial[] = new int[num+1];
		factorial[0] = 1;
		
		for(int i=1; i<=num; i++) {
			factorial[i] = factorial[i-1] * i;
		}
		
		return factorial[num];
	}
	
	static int memoizationDynamicFactorial(int num) {
		Hashtable<Integer, Integer> factorialMemo = new Hashtable<>();
		if(!factorialMemo.containsKey(num)) {
			int factorial;
			if(num == 0) {
				factorial = 1;
			} else { 
				factorial = memoizationDynamicFactorial(num - 1) * num;
			}
			factorialMemo.put(num, factorial);
			return factorial;
		} else {
			return factorialMemo.get(num);
		}
	}
	
	public static void main(String args[]) {
		int num = 6;
		
		System.out.println(recursiveFactorial(num));
		System.out.println();
		System.out.println(tabularDynamicFactorial(num));
		System.out.println();
		System.out.println(memoizationDynamicFactorial(num));
	}

}
