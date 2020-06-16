package matrix;

public class matrixMultiplication {
	
	static int N=4;
	
	static int[][] matrixMultiply(int a[][], int b[][]) {
		int out[][] = new int[4][4];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				out[i][j] = 0;
				for(int k = 0; k < N; k++) {
					out[i][j] += a[i][k] * b[k][j];
				}
			}
		}
		
		return out;
	}

	static void printValues(int mat[][]){
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				System.out.print(mat[i][j] + " ");
			}
			System.out.print("\n");
		}
	}
	public static void main(String args[]) {
		int a[][] = { {1, 1, 1, 1}, 
		                {2, 2, 2, 2}, 
		                {3, 3, 3, 3}, 
		                {4, 4, 4, 4}
		            }; 
					
		int b[][] = { {1, 1, 1, 1}, 
			            {2, 2, 2, 2}, 
			            {3, 3, 3, 3}, 
			            {4, 4, 4, 4}
			        }; 
		
		int out[][] = matrixMultiply(a, b);
		printValues(out);
					
	}
}
