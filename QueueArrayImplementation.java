package queues;

public class QueueArrayImplementation {
	
	static int front, rear, qsize;
	static int queue[];
	
	QueueArrayImplementation(int qs){
		front = 0;
		rear = 0;
		queue = new int[qs];
	}
	
	void enqueue(int val) {
		if(queue.length==rear) {
			System.out.println("Queue is full!");
			
			return;
		} else {
			queue[rear] = val;
			rear++;
		}
	}
	
	static void dequeue() {
		if(front == rear) {
			System.out.println("Queue is empty!");
			
			return;
		} else {
			for(int i=0; i<rear; i++) {
				int nxt = i+1;
				if(nxt<rear) {
					queue[i] = queue[nxt];
				} else {
					queue[i] = 0;
				}
			}
			rear--;
		}
		return;
	}
	
	static void queueDisplay() {
		for(int i=0; i<rear; i++) {
			System.out.print(queue[i] + " ");
		}
	}
	
	public static void main(String args[]) {
		
		QueueArrayImplementation q = new QueueArrayImplementation(4);
		
		System.out.print("Empty Queue: ");
		queueDisplay();
		System.out.println();
		System.out.println();
		
		q.enqueue(10);
		q.enqueue(20);
		q.enqueue(30);
		q.enqueue(40);
		
		System.out.print("After EnQueue: ");
		queueDisplay();
		System.out.println();
		System.out.println();
		
		dequeue();
		System.out.print("After Dequeue: ");
		queueDisplay();
	}

}
