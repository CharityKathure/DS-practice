package array;
/**
 * Move all zeros present in an array to the end**/
public class ArrayMoveZeros {
	static int[] shiftArraysBruteForce(int[] arr) {
		for(int i = 0; i<arr.length; i++) {
			for(int j = i; j<arr.length; j++) {
				if(arr[i]==0 && arr[j]!=0) {
					//swap values
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		return arr;
	}
	
	static int[] shiftArraysOn(int[] arr) {
		int j = 0;
		for(int i=0; i<arr.length; i++) {
			if(arr[i] != 0) {
				int temp = arr[j];
				arr[j] = arr[i];
				arr[i] = temp;
				
				j++;
			}
		}
		
		return arr;
	}

	static void printArray(int[] arr) {
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
	public static void main(String[] args) {
		int[] arr = {6, 0, 8, 2, 3, 0, 4, 0, 1};
		
		printArray(shiftArraysOn(arr));
	}
}
