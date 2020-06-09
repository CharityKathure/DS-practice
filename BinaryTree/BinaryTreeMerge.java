package brainTeasers;

/*
 * Write a program to merge two binary trees. 
 * Each node in the new tree should hold a value equal 
 * to the sum of the values of the corresponding nodes of the input trees.
 * If only one input tree has a node in a given position, 
 * the corresponding node in the new tree should match that input node.
 */
class Node{
	
	int key;
	Node left, right;
	
	Node(int val){
		key = val;
		left = right = null;
	}
}
public class BinaryTreeMerge {
	static Node r1;
	static Node r2;
	
	/*static void inOrderTraversalSum(Node n1, Node n2){
		int sum;
		if(n1 == null && n2 == null) {
			return;
		} else if(n1 != null && n2 == null){
			sum = n1.key;
			inOrderTraversalSum(n1.left, null);
			System.out.print(sum + " ");
			inOrderTraversalSum(n1.right, null);			
		} else if(n1 == null && n2 != null){
			sum = n2.key;
			inOrderTraversalSum(null, n2.left);
			System.out.print(sum  + " ");
			inOrderTraversalSum(null, n2.left);
		} else {
			sum = n2.key + n2.key;
			inOrderTraversalSum(n1.left, n2.left);
			System.out.print(sum  + " ");
			inOrderTraversalSum(n1.right, n2.right);
		}		
	}*/
	
	static void inOrderTraversal(Node n) {
		if(n == null) {
			return;
		}
		inOrderTraversal(n.left);
		System.out.print(n.key + " ");
		inOrderTraversal(n.right);
	}
	
	static Node mergeNodes(Node n1, Node n2) {
		if(n1 == null) {
			return n2;
		}
		if(n2 == null) {
			return n1;
		}
		
		n1.key = n1.key + n2.key;
		n1.left = mergeNodes(n1.left, n2.left);
		n1.right = mergeNodes(n1.right, n2.right);
		
		return n1;
	}
	
	public static void main(String args[]) {
		
		Node r1 = new Node(1);
		r1.left = new Node(2);
		r1.right = new Node(3);
		r1.left.left = new Node(4);
		r1.left.right = new Node(5);
		r1.right.right = new Node(6);
		
		Node r2 = new Node(4);
		r2.left = new Node(1);
		r2.right = new Node(7);
		r2.left.left = new Node(3);
		r2.right.left = new Node(2);
		r2.right.right = new Node(6);
		
		//mergeTree(r1, r2);
		System.out.print("R1 Inorder Traversal: ");
		inOrderTraversal(r1);
		System.out.println();
		
		System.out.print("R2 Inorder Traversal: ");
		inOrderTraversal(r2);
		System.out.println();
		
		Node r3 = mergeNodes(r1, r2);
		System.out.print("Sum of R1 and R2, Inorder Traversal: ");
		inOrderTraversal(r3);
	}
}
