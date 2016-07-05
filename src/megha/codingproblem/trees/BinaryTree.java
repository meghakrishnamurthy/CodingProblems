package megha.codingproblem.trees;

/**
 * Utility class for binary tree operations
 * @author megha krishnamurthy
 *
 */
public class BinaryTree {
	
	/**
	 * Utility method to create a binary tree
	 * @return
	 */
	public Node populateBinaryTree() {
		Node root = new Node(10);
		root.left = new Node(6);
		root.right = new Node(21);
		root.left.left = new Node(1);
		root.left.right = new Node(8);
		root.right.left = new Node(13);
		root.right.right = new Node(25);
		root.right.left.left = new Node (12);
		root.right.left.right = new Node(18);
		
		return root;
	}
}
