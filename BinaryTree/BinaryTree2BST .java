package binarySearchTree;

/*
 * Given a Binary Tree, convert it to a Binary Search Tree. 
 * The conversion must be done in such a way that keeps the original structure of Binary Tree
 */

public class BinaryTree2BST {
	 
    static int[] arr;  
    static int index = 0; 
    static int idx = 0;
	
	static class Node{
		int key;
		Node left, right;
		
		Node(int val){
			key = val;
			left = right = null;		
		}
	}
	
	static int countNodes(Node n) {
		if(n==null) {
			return 0;
		}
		return countNodes(n.left) + countNodes(n.right) + 1;
	}
	
	static void treeToArray(Node n, int arr[]){
		if(n == null) {
			return;
		}
		
		treeToArray(n.left, arr);
		arr[index] = n.key;
		index++;
		treeToArray(n.right, arr);
		
		return;
	}
	
	static void arrayToBST(Node n, int arr[]){
		if(n == null) {
			return;
		}
		arrayToBST(n.left, arr);
		n.key = arr[idx];
		idx++;
		arrayToBST(n.right, arr);
	}
	
	
	static void selectionSort(int arr[]) {
		int size = arr.length;
		int minIndex;
		
		for(int i = 0; i<size-1; i++) {
			minIndex = i;
			for(int k = i + 1; k < size; k++) {
				if(arr[k] < arr[minIndex]) {
					minIndex = k;
				}
			}
			int temp = arr[minIndex];
			arr[minIndex] = arr[i];
			arr[i] = temp;
		}
	}
	
	
	static void inorder(Node n){
		if(n == null) {
			return;
		}
		inorder(n.left);
		System.out.print(n.key + " ");
		inorder(n.right);
	}
	
	
	static void printArray(int arr[]) {
		for(int i = 0; i<arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
	
	public static void main(String args[]) {
		
		Node n = new Node(10);
		n.left = new Node(30);
		n.right = new Node(15);
		n.left.left = new Node(20);
		n.right.right = new Node(5);
		
		int nodeCount = countNodes(n);
		
		/*1. in-order Traverse the tree adding keys in an arr[]*/
		arr = new int[nodeCount];
		treeToArray(n, arr);
		
		/*2. sort arr values*/
		selectionSort(arr);
		//printArray(arr);
		
		/*3. in-order traverse the tree adding arr values in the tree*/
		arrayToBST(n, arr);
		
		inorder(n);	
		
		
	}
}
