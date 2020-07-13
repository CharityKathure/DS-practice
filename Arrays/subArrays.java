package array;

import java.util.ArrayList;
import java.util.Hashtable;

/**
 * Given an array of integer, print all sub-arrays with 0 sum**/


public class subArrays {

	static void subArrs(int[] arr, int sum){
		for(int i = 0; i<arr.length; i++) {
			int s = 0;
			for(int j = i; j<arr.length; j++) {
				s = s + arr[j];
				if(s == sum) {
					printArray(arr, i, j);
				}
			}					
		}
		
	}
	
	static void subArrsMemoization(int[] arr, int sum){
		Hashtable<Integer, ArrayList<ArrayList<Integer>>> ht = new Hashtable<>();
		for(int i = 0; i<arr.length; i++) {
			int s = 0;
			ArrayList<ArrayList<Integer>> sumList= new ArrayList<>();
			for(int j = i; j<arr.length; j++) {
				ArrayList<Integer> indexesList= new ArrayList<>();
				s = s + arr[j];
				
				if(s == sum) {
					indexesList.add(i);
					indexesList.add(j);
					
					if(ht.containsKey(s)) {
						sumList = ht.get(s);
					}
					
					sumList.add(indexesList);
				}
			}
			if(s == sum) {
				ht.put(s, sumList);
			}
		}

		System.out.println(ht.get(0));
		
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
		
		//subArrs(arr, 0);
		System.out.println();
		
		subArrsMemoization(arr, 0);
	}

}
