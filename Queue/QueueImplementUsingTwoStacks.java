package queues;

import java.util.Stack;

/*using two stacks s1 and s2, create queue q*/
public class QueueImplementUsingTwoStacks {
	
	static Stack<Integer> s1 = new Stack<>();
	static Stack<Integer> s2 = new Stack<>();
	
	void enqueue(int val) {
		while(!s1.isEmpty()) {
			s2.push(s1.pop());
		}
		
		s1.push(val);
		
		while(!s2.isEmpty()) {
			s1.push(s2.pop());
		}
	}
	
	
	static void printValues() {
		int leng = s1.size();
		for(int i=0; i<leng; i++) {
			System.out.print(s1.pop() + " ");
		}
	}
	
	
	public static void main(String args[]) {
		QueueImplementUsingTwoStacks q = new QueueImplementUsingTwoStacks(); 
		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		
		printValues();
			
		
	}

}
