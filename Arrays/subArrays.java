package array;

import java.util.ArrayList;

/**
 * Given an array of integer, print all sub-arrays with 0 sum**/


public class subArrays {

	static void subArrs(int[] arr, int sum){
		for(int i = 0; i<arr.length; i++) {
			int s = 0;
			for(int j = i; j<arr.length; j++) {
				s += arr[j];
				if(s == sum) {
					printArray(arr, i, j);
				}
			}					
		}
		
	}
	
	static ArrayList<ArrayList<Integer>> subArrsList(int[] arr, int sum){
		ArrayList<ArrayList<Integer>> subs = new ArrayList<>();
		for(int i = 0; i<arr.length; i++) {
			
			ArrayList<Integer> subsValues = new ArrayList<>();
			int s = 0;
			for(int j = i; j<arr.length; j++) {
				s = s + arr[j];
				subsValues.add(arr[j]);
				if(s == sum) {
					break;
				}
			}		
			
			if(s == 0) {
				subs.add(subsValues);
			}						
		}
		
		return subs;
	}
	
	static void printArray(int[] arr, int start, int end){
		for(int i=start; i<=end; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.print("\n");
	}
	
	public static void main(String[] args) {
		//int[] arr = {4, 2, -3, -1, 0, 4};
		int[] arr = {3, 4, -7, 3, 1, 3, 1, -4, -2, -2};
		
		subArrs(arr, 0);
		System.out.println();
		
		System.out.println(subArrsList(arr, 0));
	}

}
