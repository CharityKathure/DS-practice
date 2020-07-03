package linkedLists;

public class LinkedList {
	static Node head;
	
	static void printList() {
		Node n = head;
		while(n!=null) {
			System.out.print(n.data + " ");
			n = n.next;
		}
	}
	static void add_push(int data){
		Node newNode = new Node(data);
		newNode.next = head;
		head = newNode;
		
		return;
	}
	
	static void insertAfter(Node n, int d) {
		//base case
		if(n == null) {
			return;
		}
		
		Node newNode = new Node(d);
		
		newNode.next = n.next;
		n.next = newNode;
		
		return;
	}
	
	static void insertAtTheEnd(int d) {
		//Initialize new node
		Node newNode = new Node(d);
		
		//base case
		if(head==null) {
			head = newNode;
			
			return;
		}		
		
		
		//since it will be the last node make next node null
		newNode.next = null;
		
		//iterate to the last node
		Node last = head;
		while(last.next != null) {
			last = last.next;
		}
		
		//make the lastnode.next to be the new created node
		last.next = newNode;
	}
	
	static void deleteNode(int d) {
		Node temp = head, prev = null;
		
		//if node to be deleted is head
		if(temp != null && temp.data == d) {
			head = temp.next;
			return;
		}
		
		//if node is not head
		while(temp != null && temp.data != d) {
			prev = temp;
			temp = temp.next;
		}
		
		//if node not found in linked list
		if(temp == null) {
			return;
		}
		
		//detach
		prev.next = temp.next;
		
		return;
		
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
		
		System.out.print("\n");
		add_push(4);
		
		printList();
		
		insertAfter(second, 5);
		System.out.print("\n");
		printList();
		
		insertAtTheEnd(6);
		System.out.print("\n");
		printList();
		
		deleteNode(1);
		System.out.print("\n");
		printList();
	}
	

}
