package megha.codingproblem.trees;

import java.util.Stack;

/**
 * Depth first search implementation
 * @author megha krishnamurthy
 *
 */
public class DepthFirstSearch {

	/**
	 * This method performs a depth first search on a binary tree
	 * @param root
	 */
	public void depthFirstSearch(Node root) {
		if(root == null) {
			return;
		}
		
		Stack<Node> nodeStack = new Stack<Node>();
		nodeStack.push(root);
		
		while(!nodeStack.isEmpty()) {
			Node node = nodeStack.pop();
			System.out.print(node.data + " ");
			
			if(node.right != null) {
				nodeStack.push(node.right);
			}
			if(node.left != null) {
				nodeStack.push(node.left);
			}
		}
	}
	
	public static void main(String args[]) {
		BinaryTree tree = new BinaryTree();
		Node root = tree.populateBinaryTree();
		
		DepthFirstSearch dfs = new DepthFirstSearch();
		dfs.depthFirstSearch(root);
	}
}
