package binarySearchTree;

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
	
	static Node constructTree(int pre[], int start, int end, int size) {
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
		root.left = constructTree(pre, start, i - 1, size);
		root.right = constructTree(pre, i, end, size);
		
		return root;
	}
	
	static Node constructTreeV2(int pre[], int startIndex, int key, int min, int max, int size) {
		//Not finished -- Complexity O(N)
		
		if(min >= size) {
			return null;
		}
		
		Node root = null;
		if(key > min && key < max) {
			root = new Node(key);
			startIndex += 1;
			
			if(startIndex < size) {
				root.left = constructTreeV2(pre, startIndex, pre[startIndex], min, key, size);
				root.right = constructTreeV2(pre, startIndex, pre[startIndex], key, max, size);
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
		
		Node root = constructTree(pre, start, end, size);
		
		//Node root = constructTreeV2(pre, start, pre[0], Integer.MIN_VALUE, Integer.MAX_VALUE, size);
		printInorder(root);
	}
}
