package bitManipulation;

import java.util.Arrays;
import java.util.Stack;

/*
 * You are given a positive integer number and you have to return 
 * a boolean telling whether the input number is a tidy number or not. 
 * A tidy number is a number whose digits are in non-decreasing order. 
 * For example, 1234 is a tidy number, 
 * 122334 is also a tidy number 
 * but 143567 is not a tidy number.
 */

public class TidyNumber {
	/**Method 1.. simple easy method**/
	static boolean isTidy(int n) {
		int prev = n%10;
		while(n > 1) {
			int curr = n%10;
			if(prev < curr) {
				return false;
			} else {
				n = n/10;
				prev = curr;
			}
		}
		return true;
	}
	
	/**Method 2:: using stack**/
	static boolean stackApproach(int n) {
		Stack<Integer> s = new Stack<>();
		int temp = n;
		while(temp > 0) {
			s.add(temp%10);
			temp = temp/10;
		}
		
		return isStackTidy(s);	
	}
	
	static boolean isStackTidy(Stack<Integer> s) {
		int prev = 0;
		int i = 0;
		while(!s.isEmpty()) {
			if(i == 0) {
				prev = 0;
			} else {
				if(prev > s.peek()) {
					return false;
				}
				prev = s.peek();
				s.pop();
			}
			
			i++;
		}
		return true;
	}
	
	
	/**Method 2:: add int digits in an array, sort array, if array is equal to the initial array, return true**/
	static boolean arrayApproach(int n) {
		int arr_size = String.valueOf(n).length();
		
		int arr[] = new int[arr_size];
		int pos = arr_size - 1;
		for(int i=0; i<arr_size; i++) {
			arr[pos] = n%10;
			n = n/10;
			
			pos--;
		}
		int original_array[] = arr;
		sort(arr, 0 , pos);
		
		return Arrays.equals(original_array, arr);
	}
	
	static void sort(int arr[], int l, int r) {
		if(l < r) {
			int m = (l + r) / 2;
			
			sort(arr, l, m);
			sort(arr, m + 1, r);
			
			merge(arr, l, m, r);
		}
	}
	
	static void merge(int arr[], int l, int m, int r) {
		//count size of the arrays
		int n1 = m - l + 1;
		int n2 = r - m;
		
		//declare the arrays
		int L[] = new int[n1];
		int R[] = new int[n2];
		
		//copy values into the arrays
		for(int i = 0; i < n1; i++) {
			L[i] = arr[l + i];
		}
		for(int j = 0; j < n2; j++) {
			R[j] = arr[m + 1 + j];
		}
		
		//merge
		int i = 0, j = 0;
		int k = l;
		while(i < n1 && j < n2) {
			if(L[i] <= R[j]) {
				arr[k] = L[i];
				i++;
			} else {
				arr[k] = R[j];
				j++;
			}
			k++;
		}
		while(i < n1) {
			arr[k] = L[i];
			i++;
			k++;
		}
		while(j < n2) {
			arr[k] = R[j];
			j++;
			k++;
		}
	}
	
	
	
	static void printArray(int arr[]) {
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
	public static void main(String args[]) {
		int val = 1234;
		System.out.print(isTidy(val));
		//System.out.print(stackApproach(val));
		
		//System.out.print(arrayApproach(val));
	}
	

}
