package m_practice;

public class LinkedListInsertion {
	static Node head;
	
	static class Node{
		int data;
		Node next;
		
		Node(int d){
			data = d;
			next = null;
		}
	}
	
	static void printList() {
		Node n = head;
		while(n != null) {
			System.out.print(n.data + " ");
			n = n.next;
		}
	}
	
	static void push(int n){
		/*Method to add a node at the beginning of the linked list. Time Complexity: 0(1)*/
		Node newNode = new Node(n);
		newNode.next = head;
		head = newNode;
	}
	static void insertAfter(Node prev, int data) {
		if(prev == null) {
			return;
		}
		Node newNode = new Node(data);
		prev.next = newNode;
		newNode.next = prev.next;
	}
	public static void main(String arg[]) {
		LinkedListInsertion l1 = new LinkedListInsertion();
		l1.head = new Node(5);
		Node l2 = new Node(9);
		Node l3 = new Node(7);
		
		l1.head.next = l2;
		l2.next = l3;
		
		System.out.print("Original List: ");
		printList();
		
		
		push(8);
		System.out.println();
		System.out.print("List after adding node at the beginning : ");
		printList();
		
		/*System.out.println();
		insertAfter(head.next, 3);
		
		System.out.print("List after adding node 'l2' after: ");
		printList();*/
	}

}
