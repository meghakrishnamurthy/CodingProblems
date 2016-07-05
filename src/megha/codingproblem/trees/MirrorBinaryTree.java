package megha.codingproblem.trees;

/**
 * Class to perform mirroring of a binary tree
 * Time Complexity - O(n)
 * Space Complexity:
 *   O(h) where h is the height of the binary tree
 *   Best/average case - O(logn)
 *   Worst case - O(n)
 *      
 * @author megha krishnamurthy
 */
public class MirrorBinaryTree {
	
	/**
	 * Recursive implmentation of mirroring a binary tree
	 * @param root
	 */
	public void mirror(Node node) {
		if(node == null) {
			return;
		}
		
		mirror(node.left);
		mirror(node.right);
		
		Node temp;
		temp = node.left;
		node.left = node.right;
		node.right = temp;
	}
	
	/*
	 * Method to perform inorder traversal of a binary tree
	 */
	private void inOrder(Node node) {
		if(node == null) {
			return;
		}
		
		inOrder(node.left);
		System.out.print(node.data + " ");
		inOrder(node.right);
	}
	
	public static void main(String args[]) {
		BinaryTree tree = new BinaryTree();
		Node root = tree.populateBinaryTree();
		
		MirrorBinaryTree mirrorTree = new MirrorBinaryTree();
		mirrorTree.inOrder(root);
		System.out.println();
		mirrorTree.mirror(root);
		mirrorTree.inOrder(root);
		System.out.println();
	}
}
