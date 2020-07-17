package exercise;

public class LongestSequence {
	
	static void mergeSort(int[] arr, int l, int r) {
		if(l<r) {
			int mid = (l+r)/2;
			
			mergeSort(arr, l, mid);
			mergeSort(arr, mid+1, r);
			
			merge(arr, l, mid, r);
		}
	}
	
	static void merge(int[] arr, int l, int mid, int r) {
		int n1 = mid - l + 1;
		int n2 = r - mid;
		
		int[] L = new int[n1];
		int[] R = new int[n2];
		
		for(int i = 0; i<n1; i++) {
			L[i] = arr[l+i];
		}
		
		for(int j = 0; j<n2; j++) {
			R[j] = arr[mid + 1 + j];
		}
		
		
		int i=0, j=0, k=l;
		while(i < n1  && j < n2) {
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
	
	static int[] longestSequence(int[] arr){
		//sort array
		mergeSort(arr, 0, arr.length - 1);
				
		int maxCount = 0;
		int count = 0;
		int start = 0;
		int end = 0;
		int[] indexes = new int[2];
		for(int i = 1; i < arr.length; i++) {
			int diff =arr[i] - arr[i - 1];
			if(diff > 1) {
				//sequence broken
				//check if current count is greater than max count
				
				if(count > maxCount) {
					//if greater, update maxCount
					maxCount = count;
					end = i;
					
					indexes[0] = arr[start];
					indexes[1] = arr[end];
				}
				//reset count
				count = 0;
				start = i+1;
			} else {
				//increment count
				count += 1;
			}	
		}
		
		
		if(maxCount == 0) {
			indexes[0] = arr[0];
			indexes[1] = arr[arr.length - 1];
		}
		
		
		return indexes;
	}
	
	static void printArray(int arr[]) {
		for(int i=0; i< arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
	public static void main(String[] args) {
		int[] arr = {0,9, 19, -1, 18, 17, 2, 10, 3, 12, 5, 16, 4, 11, 8, 7,  6, 15, 12, 12, 2, 1, 6, 13, 14};
		
				
		printArray(longestSequence(arr));
	}

}
