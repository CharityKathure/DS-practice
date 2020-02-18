package practice13022020;
/*
 * A Collatz sequence in mathematics can be defined as follows: 
 * 	Starting with any positive integer:
 * 	if n is even, the next number in the sequence is n / 2
 * 	if n is odd, the next number in the sequence is 3n + 1
 * 	It is conjectured that every such sequence eventually reaches the number 1. Test this conjecture.
 * 
 * Bonus: What input n <= 1000000 gives the longest sequence?
 */
public class Collatz {
	
	static int collatz(int num){
		while(num > 1) {
			
			if(num%2 == 0) {
				num = num/2;
			} else {
				num = (3*num) + 1;
			}
			
			System.out.println(num);
		}
		return num;
	}
	
	public static void main(String[] args) {
		int n = 1000000;
		int val = collatz(n);
		
		System.out.println("Finally = " + val);
	}

}
