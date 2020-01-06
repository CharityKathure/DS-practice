package m_practice;

public class ArrayRotation {
	
	/*Write a function rotate(ar[], d, n) that rotates arr[] of size n by d elements.*/
	
	static void rotate(int[]arr, int rotation_no, int arr_size){
		
		int[]arr1 = new int[rotation_no];
		for(int i = 0; i< rotation_no; i++) {
			arr1[i] = arr[i]; 
			pushLeft(arr, arr_size);
		}
	}
	
	static int[] pushLeft(int[]arr, int arr_size){
		int i;
		int temp_val = arr[0];
		
		for(i = 0; i< arr_size - 1; i++) {
			arr[i] = arr[i+1];
		}
		arr[i]  = temp_val;
		
		return arr;
	}
	
	static void printArray(int arr[]) {
		for(int i = 0; i<arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
	public static void main(String [] args) {
		int[]arr = {1,2,3,4,5,6,7};
		rotate(arr, 2 , arr.length);
		
		printArray(arr);
	}
}
