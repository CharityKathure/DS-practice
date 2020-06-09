package queues;

import java.util.LinkedList;
import java.util.Queue;

public class QueueJavaInteface {
	
	public static void main(String args[]) {
		
		Queue<Integer> q = new LinkedList<>();
		
		//add elements in queue
		for(int i=0; i<5; i++) {
			q.add(i);
		}
		System.out.println(q);
		
		//delete from Queue
		q.poll();
		System.out.println(q);
		
		//print the first element in queue
		int front = q.peek();
		System.out.println("Front: " + front);
		
		//get size of queue
		int qSize = q.size();
		System.out.println("Queue Size: " + qSize);
	}

}
