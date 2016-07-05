package megha.codingproblem.trees;

/**
 * Class to perform the different DFS traversals on a binary tree:
 * 1. Pre order traversal
 * 2. In order traversal
 * 3. Post order traversal
 * 
 * Time complexity of these operations - O(n)
 * Space complexity of these operations:
 *   O(h) where h is the height of the binary tree
 *   Best/average case - O(logn)
 *   Worst case - O(n)
 * 
 * @author megha krishnamurthy
 *
 */
public class PreorderInorderPostorder {

	/**
	 * Method to perform pre order traversal of a binary tree
	 * @param node
	 */
	public void preOrder(Node node) {
		if(node == null) {
			return;
		}
		System.out.print(node.data + " ");
		preOrder(node.left);
		preOrder(node.right);
	}
	
	/**
	 * Method to perform in order traversal of a binary tree
	 * @param node
	 */
	public void inOrder(Node node) {
		if(node == null) {
			return;
		}
		inOrder(node.left);
		System.out.print(node.data + " ");
		inOrder(node.right);
	}
	
	/**
	 * Method to perform post order traversal of a binary tree
	 * @param node
	 */
	public void postOrder(Node node) {
		if(node == null) {
			return;
		}
		postOrder(node.left);
		postOrder(node.right);
		System.out.print(node.data + " ");
	}
	
	public static void main(String args[]) {
		BinaryTree tree = new BinaryTree();
		Node root = tree.populateBinaryTree();
		PreorderInorderPostorder treeOrder = new PreorderInorderPostorder();
		
		//Pre-order traversal
		treeOrder.preOrder(root);
		System.out.println();
		
		//In order traversal
		treeOrder.inOrder(root);
		System.out.println();
		
		//Post-order traversal
		treeOrder.postOrder(root);
		System.out.println();
	}
}
