package linkedLists;

import java.util.HashSet;
import java.util.Stack;

public class LinkedList {
	static Node head;
	
	static void printList() {
		Node n = head;
		while(n!=null) {
			System.out.print(n.data + " ");
			n = n.next;
		}
	}
	static void printList(Node n) {
		Node temp = n;
		while(temp!=null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
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
		if(pos == 0) {
			head = temp.next;
			return;
		}
		for(int i = 0; temp!=null && i<pos-1; i++) {
			temp = temp.next;
		}
		
		//find previous of the node to be deleted
		if(temp == null || temp.next == null) {
			return;
		}
		
		temp.next = temp.next.next;
		return;
	}
	
	static int linkedListLength() {
		Node temp = head;
		
		int count = 0;
		while(temp!=null) {
			temp = temp.next;
			count++;
		}
		
		return count;
	}
	
	static int linkedListLengthRecur(Node n) {
		if(n == null) {
			return 0;
		}
		
		return 1 + linkedListLengthRecur(n.next);
	}
	
	static boolean detectLoop(Node n) {
		HashSet<Node> s = new HashSet<>(); 
		while(n!=null) {
			if(s.contains(n)) {
				return true;
			}
			s.add(n);
			n = n.next;
		}
		return false;
	}
	
	static int loopLength(Node n) {
		Node slow_ptr = n, fast_ptr = n;
		
		while(slow_ptr != null && fast_ptr != null && fast_ptr.next != null) {
			slow_ptr = slow_ptr.next;
			fast_ptr = fast_ptr.next.next;
			
			/* If slow_ptr and fast_ptr meet at some point then there is a loop */
			if(slow_ptr == fast_ptr) {
				return countLoopLength(slow_ptr);
			}
		}
		return 0;
	}
	
	static int countLoopLength(Node n) {
		int count = 1;
		Node temp = n;
		while(temp != null) {
			count++;
			temp = temp.next;
		}
		return count;
	}
	
	static boolean isPalindrome(Node n) {
		//using stack
		Stack<Integer> s = new Stack<>();
		Node temp = n;
		while(temp!=null) {
			s.push(temp.data);
			temp = temp.next;
		}
		
		temp = n;
		while(temp != null) {
			int curr = s.peek();			
			if(curr != temp.data) {
				return false;
			}
			s.pop();
			temp = temp.next;
		}
		
		return true;
	}
	
	static Node reverseList(Node n) {
		Node prev=null, curr=n, next=null;
		while(curr != null) {
			next = curr.next;
			
			////reversal happens here
			curr.next = prev;
			prev = curr;
			
			curr = next;
		}
		
		n = prev;
		
		return n;
	}
	
	static void reverseNodeIteratively() {
		//3 pointers
		Node prev = null;
		Node curr = head;
		Node nxt = null;
		
		while(curr!=null){
			nxt = curr.next;
			//reverse
			curr.next = prev;
			prev = curr;
			curr = nxt;
		}
		
		head = prev;
	}
	
	
	static Node reverseRecursive(Node head) {
		if(head == null || head.next == null) {
			return head;
		}
		
		/* reverse the rest list and put the first element at the end */
		Node rest = reverseRecursive(head.next);
		head.next.next = head;
		
		
		head.next = null;
		
		return rest;
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
		
		reverseNodeIteratively();
		System.out.print("\n");
		printList();
		
		System.out.print("\n");
		System.out.println("Linked List Length: " + linkedListLength());
		
		System.out.print("\n");
		System.out.println("List has loop? " + detectLoop(head));
		
		Node one = new Node(1); 
        Node two = new Node(2); 
        Node three = new Node(3); 
        Node four = new Node(4); 
        Node five = new Node(3); 
        Node six = new Node(2); 
        Node seven = new Node(2); 
        one.next = two; 
        two.next = three; 
        three.next = four; 
        four.next = five; 
        five.next = six; 
        six.next = seven; 
		System.out.print("\n");
		printList(one);
		System.out.println("is List Palindrome? " + isPalindrome(one));
		
		one  = reverseList(one);
		printList(one);
	}
	

}
