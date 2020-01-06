package m_practice;

public class ArrayRotationReverseAlgorithm {
	/*Write a function rotate(ar[], d, n) that rotates arr[] of size n by d elements.*/
	
	static void leftRotate(int[] arr, int rcount){
		if(rcount == 0) {
			return;
		} else {
			int n = arr.length;
			reverse(arr, 0, rcount-1);
			reverse(arr, rcount, n-1);
			reverse(arr, 0, n-1);
		}
	}
	
	static int[] reverse(int[] arr, int start, int end) {
		int temp;
		while(start < end) {
			temp = arr[start];
			
			arr[start] = arr[end];
			
			arr[end] = temp;
			
			start++;
			end--;
		}
		
		return arr;
	}
	
	static void printArray(int arr[]) {
		for(int i = 0; i<arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
	
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6,7};
		int n = arr.length;
		
		int d = 2;
		d = d%n;
		
		leftRotate(arr, d);
		
		printArray(arr);
	}
}
