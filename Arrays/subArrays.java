package array;
/**
 * Given an array of integer, print all sub-arrays with 0 sum**/

import java.util.ArrayList;

public class subArrays {

	static ArrayList<ArrayList<Integer>> subArrs(int[] arr, int sum){
		ArrayList<ArrayList<Integer>> subs = new ArrayList<>();
		for(int i = 0; i<arr.length; i++) {
			
			ArrayList<Integer> subsValues = new ArrayList<>();
			subsValues.add(arr[i]);
			int s = arr[i];
			
			for(int j = i + 1; j<arr.length; j++) {
				if(s == sum) {
					break;
				}
				s = s + arr[j];
				subsValues.add(arr[j]);
			}		
			
			
			if(s == 0) {
				subs.add(subsValues);
			}				
			
			
		}
		
		return subs;
	}
	
	public static void main(String[] args) {
		//int[] arr = {4, 2, -3, -1, 0, 4};
		int[] arr = {3, 4, -7, 3, 1, 3, 1, -4, -2, -2};
		int sum = 0;
		
		ArrayList<ArrayList<Integer>> subArrs = subArrs(arr, sum);
		
		System.out.println(subArrs);
	}

}
