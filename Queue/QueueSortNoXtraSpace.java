package queues;

import java.util.Queue;
import java.util.LinkedList;

/* Given a queue with random elements, sort it. You are not allowed to use extra space */

public class QueueSortNoXtraSpace {
	
	static void sort(Queue<Integer> q) {
		for(int i=1; i<=q.size(); i++) {
			int min_index = findMinIndex(q, q.size() - i);
			insertMinToRear(q, min_index);
		}		
	}
	
	static int findMinIndex(Queue<Integer> q, int sortIndex) {
		
		int min_index = -1;
		int min_value = Integer.MAX_VALUE;
		int size = q.size();
		for(int i=0; i<size; i++) {
			int current = q.peek();
			q.poll();
			
			if(current<=min_value && i<=sortIndex) {
				min_index = i;
				min_value = current;
			}
			
			q.add(current);
		}
		
		return min_index;
	}
	
	static Queue<Integer> insertMinToRear(Queue<Integer> q, int min_index) {
		int qSize = q.size();
		int min_value = 0;
		for(int i=0; i<qSize; i++) {
			int current = q.peek();
			q.poll();
			if(i != min_index) {
				q.add(current);
				
			} else {
				min_value = current;
			}
		}
		q.add(min_value);
		
		return q;
	}
	
	static void printVals(Queue<Integer> q) {
		int qSize = q.size();
		for(int i=0; i<qSize; i++) {
			System.out.print(q.peek() + " ");
			q.poll();
		}
	}
	
	public static void main(String arg[]) {
		//implement queue using LinkedList
		Queue<Integer> q = new LinkedList<>();
		
		q.add(5);
		q.add(2);
		q.add(10);
		q.add(99);
		
		sort(q);
		
		printVals(q);
		
	}

}
