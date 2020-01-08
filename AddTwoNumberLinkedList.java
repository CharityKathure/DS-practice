package m_practice;

import java.util.Stack;

/*
 * You are given two non-empty linked lists representing two non-negative integers. 
 * The digits are stored in reverse order and each of their nodes contain a single digit. 
 * Add the two numbers and return it as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 */
public class AddTwoNumberLinkedList {
	
	static ListNode head1;
	static ListNode head2;
	static ListNode head3;
	
	static class ListNode {
		int data;
		ListNode next;
		
		//constructor
		ListNode(int d){
			data = d;
			next = null;
		}
	}
	
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		int carry = 0;
		ListNode prevNode = null;
        while(l1 != null || l2 != null) {
        	
        	ListNode l2Sec = new ListNode(l1.data + l2.data);
        	
        	l2Sec.data  = l2Sec.data + carry;
        	carry = l2Sec.data / 10;
        	l2Sec.data = l2Sec.data % 10;

        	if(prevNode == null) {
        		AddTwoNumberLinkedList l3 = new AddTwoNumberLinkedList();
        		l3.head3 = new ListNode(l2Sec.data);
        		prevNode = l3.head3;
        	} else {
        		prevNode.next = new ListNode(l2Sec.data);
        	}
        	
        	l1 = l1.next;
        	l2 = l2.next;
        }
        
        //printList(prevNode);
		return prevNode;
    }
	
	static ListNode reverse(ListNode node) {
		ListNode prev = null;
		ListNode curr = node;
		ListNode nxt = null;
		
		while(curr != null) {
			nxt = curr.next;
			curr.next = prev;
			
			prev = curr;
			curr = nxt;
		}
		
		node = prev;
		
		return node;
	}
	
	static void printList(ListNode n){
		while(n != null) {
			System.out.print(n.data + " ");
			n = n.next;
		}
	}
	
	public static void main(String args[]) {
		AddTwoNumberLinkedList l1 = new AddTwoNumberLinkedList();
		l1.head1 = new ListNode(2);
		ListNode l1Sec = new ListNode(4);
		ListNode l1Trd = new ListNode(3);
		
		l1.head1.next = l1Sec;
		l1Sec.next = l1Trd;
		
		System.out.print("LinkedList1: ");
		printList(head1);
		
		System.out.println(" ");
		
		AddTwoNumberLinkedList l2 = new AddTwoNumberLinkedList();
		l2.head2 = new ListNode(5);
		ListNode l2Sec = new ListNode(6);
		ListNode l2Trd = new ListNode(4);
		
		l2.head2.next = l2Sec;
		l2Sec.next = l2Trd;
		
		System.out.println(" ");
		System.out.print("LinkedList2: ");
		printList(head2);
		System.out.println(" ");
		//reverse LinkedLists
		
		//sum LinkedList values
		ListNode sumList = addTwoNumbers(head1, head2);
		System.out.println(" ");
		System.out.print("LinkedList Sum: ");
		printList(sumList);
		System.out.println(" ");
	}
}
