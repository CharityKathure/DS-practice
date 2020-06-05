package queues;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class QueueReversal {
	
	static Queue<Integer> q = new LinkedList<>();
	static Stack<Integer> s = new Stack<>();
	
	void enqueue(int val) {
		q.add(val);
	}
	
	void reverse(){
		int qSize = q.size();
		for(int i=0; i<qSize; i++) {
			/*s.add(q.peek());
			q.remove();*/
			s.push(q.poll());
		}
		return;
	}
	
	void printVals() {
		int stackSize = s.size();
		for(int i=0; i<stackSize; i++) {
			System.out.print(s.pop() + " ");
		}
	}
	
	public static void main(String args[]) {
		QueueReversal que = new QueueReversal();
		que.enqueue(1);
		que.enqueue(2);
		que.enqueue(3);
		que.enqueue(4);
		
		//reverse queue using stack
		que.reverse();
		
		//print values
		que.printVals();
	}
}
