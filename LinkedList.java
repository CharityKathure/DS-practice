package m_practice;

public class LinkedList {
	static Node head;
	
	static class Node {
		int data;
		Node next;
		
		Node(int d){
			data = d;
			next = null;
		}
	}
	
	static void push(int data) {
		/*add data at the beginning of the list*/
		Node newNode = new Node(data);
		
		newNode.next = head;
		head = newNode;
	}
	
	static void insertAfter(Node prevNode, int data) {
		if(prevNode == null) {
			return;
		}
		
		Node newNode = new Node(data);
		
		newNode.next = prevNode.next;
		prevNode.next = newNode;
		
	}
	
	static void printList() {
		Node temp = head;
		while(temp != null) {
			System.out.print(" " + temp.data);
			temp = temp.next;
		}
	}
	
	static void append(int data) {
		Node newNode = new Node(data);
		if(head == null) {
			head = newNode;
			return;
		}
		
		newNode.next = null;
		
		Node last = head;
		while(last.next != null) {
			last = last.next;
		}
		
		last.next = newNode;
	}
	
	static void deleteNodegivenValue(int data) {
		if(head==null) {
			return;
		}
		
		if(head!=null && head.data==data) {
			head = head.next;
		}
		
		Node temp = head, prev=null;
		while(temp!=null && temp.data !=data) {
			prev = temp;
			temp = temp.next;
		}
		
		prev.next=temp.next;
	}
	
	static void deleteNodegivenPosition(int position) {
		if(head==null) {
			return;
		}
		if(position==0) {
			head=head.next;
		}
		
		Node temp=head, prev=null;
		for(int i=0; temp!=null&&i<position-1; i++) {
			prev=temp;
			temp=temp.next;
		}
		
		if(temp==null || temp.next==null) {
			return;
		}
		
		prev.next=temp.next;
	}
	
	public static void main(String[] args) {
		LinkedList llist = new LinkedList();
		
		llist.push(7);
		llist.push(1);
		llist.push(3);
		llist.push(2);
		llist.push(8);
		
		System.out.print("List 1: ");
		printList();
		
		System.out.println("");
		
		Node n = head.next.next;
		insertAfter(n, 5);
		
		System.out.print("List 2: ");
		printList();
		
		System.out.println("");
		append(6);
		System.out.print("List 3: ");
		printList();
		
		deleteNodegivenValue(3);
		System.out.println("");
		System.out.print("List 4: ");
		printList();
		
		deleteNodegivenPosition(5);
		System.out.println("");
		System.out.print("List 5: ");
		printList();
	}
}
