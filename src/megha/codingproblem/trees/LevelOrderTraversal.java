package megha.codingproblem.trees;

import java.util.LinkedList;
import java.util.Queue;
/**
 * Class to perform a level order traversal or BFS on a binary tree
 * Time complexity - O(n)
 * Space complexity - Average of O(1) and worst case of O(n)
 * @author megha krishnamurthy
 *
 */
public class LevelOrderTraversal {
	public void levelOrderTraversal(Node root) {
		if(root == null) {
			return;
		}
		
		Queue<Node> nodeQueue = new LinkedList<Node>();
		nodeQueue.add(root);
		
		while(!nodeQueue.isEmpty()) {
			Node currentNode = nodeQueue.remove();
			System.out.print(currentNode.data + " ");
			if(currentNode.left != null) {
				nodeQueue.add(currentNode.left);
			}
			if(currentNode.right != null) {
				nodeQueue.add(currentNode.right);
			}
		}
	}
	
	public static void main(String args[]) {
		BinaryTree tree = new BinaryTree();
		Node root = tree.populateBinaryTree();
		
		LevelOrderTraversal levelTraversal = new LevelOrderTraversal();
		levelTraversal.levelOrderTraversal(root);
	}
}
