package binarySearchTree;

import java.util.Stack;

/*
 * Construct Binary Search Tree from a given pre-order traversal
 */
class Node{
	
	int key;
	Node left, right;
	
	Node(int n){
		key = n;
		left = right = null;
	}
}

public class ConstructBST {
	
	static Node constructTreeV1(int pre[], int start, int end, int size) {
		//Finished - Complexity O(N^2)
		
		//base case
		if(start >= size || start > end) {
			return null;
		}
		
		//mark 1st value in the pre-order array as root and increment start
		Node root = new Node(pre[start]);
		start += 1
				;
		//if only one element is in the array, return node
		if(start == end) {
			return root;
		}
		
		//get the next/1st value greater than root value
		int i;
		for(i = start; i <= end; i++) {
			if(pre[i] > root.key) {
				break;
			}
		}
		
		//use index obtained to divide the pre-order array into two; 
			//1. from start to i-1 
			//2. from i to n
		root.left = constructTreeV1(pre, start, i - 1, size);
		root.right = constructTreeV1(pre, i, end, size);
		
		return root;
	}
	
	static Node constructTreeV2(int pre[], int size) {
		// Complexity O(N)
		
		//first val is root
		Node root = new Node(pre[0]);
		
		Stack<Node> s = new Stack<>();
		s.push(root);
		
		//iterate through the other keys in pre[]
		for(int i=1; i<size; i++) {
			Node temp = null;
			//while stack is not empty and pre[i] is greater than value on top keep popping 
			while(!s.isEmpty() && pre[i] > s.peek().key) {
				temp = s.pop();
			}
			
			if(temp != null) {
				temp.right = new Node(pre[i]);
				s.push(temp.right);
			} else {
				temp = s.peek();
				temp.left = new Node(pre[i]);
				s.push(temp.left);
			}
		}
		
		return root;
	}
	
	static void printInorder(Node root) {
		if(root == null) {
			return;
		}
		printInorder(root.left);
		System.out.print(root.key + " ");
		printInorder(root.right);
	}

	public static void main(String args[]) {
		int pre[] = new int[]{10, 5, 1, 7, 40, 50}; 
		int size = pre.length; 
		int start = 0;
		int end = size;
		
		Node root1 = constructTreeV1(pre, start, end, size);
		Node root2 = constructTreeV2(pre, size);
		
		System.out.print("Using O(N^2) Time Complexity: ");
		printInorder(root1);
		
		System.out.println("");
		
		System.out.print("Using O(N) Time Complexity: ");
		printInorder(root2);
	}
}
