package binarySearchTree;

public class BST {
	
	class Node{
		int key;
		Node left, right;
		
		Node(int val){
			key = val;
			left = right = null;
		}
	}
	
	Node root;
	
	BST(){
		root = null;
	}
	
	void insert(int val) {
		root = insertVal(root, val);
	}
	
	Node insertVal(Node r, int v) {
		if(r == null) {
			r = new Node(v);
			return r;
		}
		if(v < r.key) {
			r.left = insertVal(r.left, v);
			
		} else if(v > r.key) {
			r.right = insertVal(r.right, v);
		}
		return r;
	}
	
	Node search(Node root, int key) {
		if(root == null || root.key == key) {
			return root;
		}
		if(key < root.key) {
			return search(root.left, key);
		} else {
			return search(root.right, key);
		}
	}
	
	void inOrder(Node root) {
		if(root == null) {
			return;
		}
		inOrder(root.left);
		System.out.print(root.key + " ");
		inOrder(root.right);
	}
	
	public static void main(String args[]) {
		BST tree = new BST();
		
		tree.insert(50); 
        tree.insert(30); 
        tree.insert(20); 
        tree.insert(40); 
        tree.insert(70); 
        tree.insert(60); 
        tree.insert(80); 
        
        tree.inOrder(tree.root);
        
        //tree.inOrder(tree.search(tree.root, 80));
	}

}
