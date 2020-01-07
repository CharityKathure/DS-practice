package m_practice;


public class SimpleLinkedList {
	static Node head;
	
	static class Node {
		int data;
		Node next;
		
		//constructor
		Node(int d){
			data = d;
			next = null;
		}
	}
	
	void printList(){
		Node n = head;
		while(n != null) {
			System.out.print(n.data + " ");
			n = n.next;
		}
	}
	
	static Node reverse(Node node) {
		Node prev = null;
		Node curr = node;
		Node nxt = null;
		
		while(curr != null) {
			nxt = curr.next;
			curr.next = prev;
			
			prev = curr;
			curr = nxt;
		}
		
		node = prev;
		
		return node;
	}
	
	public static void main(String args[]) {
		SimpleLinkedList llist = new SimpleLinkedList();
		
		llist.head = new Node(1);
		Node second = new Node(2);
		Node third = new Node(3);
		
		llist.head.next = second;
		second.next = third;
		
		System.out.print("Linked List: ");
		llist.printList();
		
		System.out.println("");
		
		head = reverse(head);
		
		System.out.print("Reversed Linked List: ");
		llist.printList();
		
	}

}
