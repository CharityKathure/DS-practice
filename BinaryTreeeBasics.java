package binaryTrees;

import java.util.LinkedList;
import java.util.Queue;

class Node{
	int key;
	Node left, right;
	
	Node(int item){
		key = item;
		left = right = null;
	}
}


public class BinaryTreeeBasics {
	Node root;
	
	void printInorder(Node node) {
		if(node == null) {
			return; 
		} else {
			printInorder(node.left);
			System.out.print(node.key + " ");
			printInorder(node.right);
		}
	}
	 
	void printPostOrder(Node node) {
		if(node == null) {
			return; 
		} else { 
			printPostOrder(node.left);
			printPostOrder(node.right);
			System.out.print(node.key + " ");
		}
	}
	
	void printPreOrder(Node node) {
		if(node == null) {
			return;
		} else {
			System.out.print(node.key + " ");
			printPreOrder(node.left);
			printPreOrder(node.right);
		}
	}
	
	int treeHeight(Node node) {
		//check if tree is empty and return 0 if empty
		if(node == null) {
			return 0;
		}
		
		int leftHeight = treeHeight(node.left);
		int rightHeight = treeHeight(node.right);
		
		//return the bigger
		if(leftHeight > rightHeight) {
			return leftHeight + 1;
		} else {
			return rightHeight + 1;
		}
	}
	
	void printLevelOrder(Node node) {
		int h = treeHeight(node);
		for(int i=1; i<=h; i++) {
			printGivenLevel(node, i);
		}
	}
	
	void printGivenLevel(Node node, int level) {
		if(node == null) {
			return;
		}
		if(level == 1) {
			System.out.print(node.key + " ");
		}
		if(level > 1) {
			printGivenLevel(node.left, level-1);
			printGivenLevel(node.right, level-1);
		}
	}
	
	
	void insert(Node node, int val) {
		Queue<Node> q = new LinkedList<>();
		
		q.add(node);
		while(!q.isEmpty()) {
			node = q.peek();
			q.poll();
			
			if(node.left == null) {
				node.left = new Node(val);
				break;
			} else {
				q.add(node.left);
			}
			if(node.right == null) {
				node.right = new Node(val);
				break;
			} else {
				q.add(node.right);
			}
			
		
		}
	}
	 
	public static void main(String args[]) {
		
		BinaryTreeeBasics bt = new BinaryTreeeBasics();
		
		bt.root = new Node(1);
		
		bt.root.left = new Node(2);
		bt.root.right = new Node(3);
		
		bt.root.left.left = new Node(4);
		bt.root.left.right = new Node(5);
		
		System.out.print("InOrder Traversal: ");
		bt.printInorder(bt.root);
		System.out.println();
		
		System.out.print("PreOrder Traversal: ");
		bt.printPreOrder(bt.root);
		System.out.println();
		
		System.out.print("PostOrder Traversal: ");
		bt.printPostOrder(bt.root);
		System.out.println();
		
		System.out.print("Level Order/Breadth First Traversal: ");
		bt.printLevelOrder(bt.root);
		System.out.println();
		
		bt.insert(bt.root, 6);
		System.out.print("InOrder Traversal after Insert: ");
		bt.printInorder(bt.root);
		System.out.println();
		
	}
}
