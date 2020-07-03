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
	
	static void deleteNodeGivenKey(int d) {
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
	
	static void deleteNodeGivenPos(int pos) {
		//if node is empty
		if(head == null) {
			return;
		}
		
		Node temp = head;
		//if node to be deleted is the head
		if(temp != null && pos == 0) {
			head = temp.next;
		}
		
		//find previous of the node to be deleted
		for(int i = 0; temp != null && i < pos-1; i++) {
			temp = temp.next;
		}
		
		//if node is no found
		if(temp == null || temp.next == null) {
			return;
		}
		
		//detach
		Node next = temp.next.next; 
        temp.next = next;
	}
	
	public static void main(String args[]) {
		LinkedList n = new LinkedList();
		
		n.head = new Node(1);
		Node second = new Node(2);
		Node third = new Node(3);
		Node fourth = new Node(7);
		
		n.head.next = second;
		second.next = third;
		third.next = fourth;
		
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
		
		deleteNodeGivenKey(1);
		System.out.print("\n");
		printList();
		
		deleteNodeGivenPos(1);
		System.out.print("\n");
		printList();
	}
	

}
