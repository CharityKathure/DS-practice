package m_practice;

public class InvertionCount {

	static int invCT(int arr[]){
		//Time Complexity: O(n^2)
		int invertionCount = 0;
		for(int i=0; i<arr.length-1; i++) {
			for(int j = i+1; j<arr.length; j++) {
				if(arr[j] <arr[i]) {
					System.out.print(arr[i]+"-"+ arr[j]+", ");
					invertionCount++;
				}
			}
		}
		return invertionCount;
	}
	static int countmerge(int arr[], int l, int m, int r) {
		//copy array into sub-arrays
		
		int n1 = (m - l)+ 1;
		int n2 = r - m;
		
		int L[] = new int[n1];
		int R[] = new int[n2];
		for(int i = 0; i<n1; i++) {
			L[i] = arr[l + i];
		}
		for(int j = 0; j<n2; j++) {
			R[j] = arr[m + 1 + j];
		}
		int i = 0, j = 0, k = l, swaps=0;
		while(i<n1 && j<n2) {
			if(L[i] < R[j]) {
				arr[k] = L[i];
				i++;
			} else {
				arr[k] = R[j];
				j++;
				swaps += (m + 1) - (l + i); 
			}
			k++;
		}
		while(i<n1) {
			arr[k] = L[i];
			i++;
			k++;
		}
		while(j<n2) {
			arr[k] = R[j];
			j++;
			k++;
		}
		
		return swaps;
	}
	
	static int countmergeSort(int arr[], int l, int r) {
		//Time Complexity: O(N log N)
		int count = 0;
		if(l<r){
			int m = (l+r)/2;
			
			count+= countmergeSort(arr, l, m);
			count+= countmergeSort(arr, m+1, r);
			
			count+= countmerge(arr, l, m, r);
		}
		return count;
	}
	
	static void printArray(int arr[]) {
		for(int i = 0; i<arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
	
	public static void main(String args[]) {
		int arr[] = new int[] {2, 4, 1, 3, 5}; 
		
		//Method 1: Nested Loop
		int count = invCT(arr);
		System.out.println();
		System.out.println("Inversion Count: " + count);
		
		//Method 2: count using merge sort
		int mergeCount = countmergeSort(arr, 0, arr.length - 1);
		System.out.println("MergeSort Inversion Count: " + mergeCount);
	}
}
