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
	
	
	Node deleteKey(Node root, int key) {
		if(root == null) {
			return root;
		}
		if(key < root.key) {
			root.left = deleteKey(root.left, key);
		} else if(key > root.key) {
			root.right = deleteKey(root.right, key);
		} else {
			
			//if equal to current node//
			if(root.left == null) {
				return root.right;
			} else if(root.right == null) {
				return root.left;
			}
			
			//if both left and right are not null//
			//get smallest node in the right(the Successor)
			root.key = minVal(root.right);
			root.right = deleteKey(root.right, root.key);
			
		}
		
		return root;
	}
	
	int minVal(Node root) {
		int min = root.key;
		while(root.left != null) {
			min = root.left.key;
			root = root.left;
		}
		
		return min;
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

		Node n = tree.root;
		tree.inOrder(n);

		System.out.println();

		tree.deleteKey(n, 70);
		tree.inOrder(n);

        	//tree.inOrder(tree.search(n, 80));
	}

}
