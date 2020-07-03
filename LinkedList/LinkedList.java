package linkedLists;

class Node {
	int data;
	Node next;
	
	Node(int d){
		data = d;
		next = null;
	}
}

public class LinkedList {
	static Node head;
	
	
	
	static void printList() {
		Node n = head;
		while(n!=null) {
			System.out.print(n.data + " ");
			n = n.next;
		}
	}
	
	public static void main(String args[]) {
		LinkedList n = new LinkedList();
		
		n.head = new Node(1);
		Node second = new Node(2);
		Node third = new Node(3);
		
		n.head.next = second;
		second.next = third;
		
		//traversal
		printList();
	}
	

}
