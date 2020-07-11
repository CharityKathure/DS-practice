package dynamicProgramming;

public class LongestCommonSubsequence {
	
	static int longestCommonSubsequence(char[] X, char[] Y, int l, int r) {
		if(l==0 || r==0) {
			return 0;
		} else {
			if(X[l-1] == Y[r-1]) {
				return 1 + longestCommonSubsequence(X, Y, l-1, r-1);
			} else {
				return max(longestCommonSubsequence(X, Y, l, r-1), longestCommonSubsequence(X, Y, l-1, r));
			}
		}
	}
	
	static int max(int num1, int num2) {
		if(num1 > num2) {
			return num1;
		} else {
			return num2;
		}
	}
	
	
	public static void main(String[] args) {
		String s1 = "AGGTAB"; 
	    String s2 = "GXTXAYB";
	    
	    char[] X = s1.toCharArray();
	    char[] Y = s2.toCharArray();
	    
	    int l = X.length;
	    int r = Y.length;
	    
	    int lcs = longestCommonSubsequence(X, Y, l, r);
	    
	    System.out.println("longest Common Sub-sequence: " + lcs);
	}

}
