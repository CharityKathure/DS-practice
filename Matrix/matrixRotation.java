package matrix;

public class matrixRotation {
	
	static int R = 4;
	static int C = 4;
	
	static void rotate(int r, int c, int mat[][]) {
		int row = 0, col = 0; 
		int prev, curr; 
		
		while(row < r && col < c) {
			if(row + 1 == r || col + 1 == c) 
				break;
			
			prev = mat[row + 1][col];
			
			//shift 1st row elements
			for(int i = col; i < c; i++) {
				curr = mat[row][i];
				mat[row][i] = prev;
				prev = curr;
			}
			row++;
			
			//shift last column elements
			for(int i = row; i < r; i++) {
				curr = mat[i][c-1];
				mat[i][c-1] = prev;
				prev = curr;
			}
			c--;
			
			//shift last row elements
			if(row < r) {
				for(int i = c-1; i >= col; i--) {
					curr = mat[r-1][i];
					mat[r-1][i] = prev;
					prev = curr;
				}
			}
			r--;
			
			//shift 1st column elements 
			if(col < c) {
				for(int i = r-1; i >= row; i--) {
					curr = mat[i][col];
					mat[i][col] = prev;
					prev = curr;
				}
			}
			col++;
		}
		printMatrix(mat);
	}
	
	static void printMatrix(int mat[][]){
		for(int i=0; i < R; i++) {
			for(int j=0; j < C; j++) {
				System.out.print( mat[i][j] + " "); 
			}
			System.out.print("\n");
		}
	}
	public static void main(String args[]) {
		int mat[][] = {
				{1, 2, 3, 4}, 
				{5, 6, 7, 8}, 
				{9, 10, 11, 12}, 
				{13, 14, 15, 16}
			};
		
		rotate(R, C, mat);
	}
}
