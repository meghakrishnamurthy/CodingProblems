package megha.codingproblem.trees;

import java.util.LinkedList;
import java.util.Queue;
/**
 * Class to perform a level order traversal or BFS on a binary tree
 * @author megha krishnamurthy
 *
 */
public class LevelOrderTraversal {
	public static void levelOrderTraversal(Node root) {
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
		Node root = new Node(10);
		root.left = new Node(6);
		root.right = new Node(21);
		root.left.left = new Node(1);
		root.left.right = new Node(8);
		root.right.left = new Node(13);
		root.right.right = new Node(25);
		root.right.left.left = new Node (12);
		root.right.left.right = new Node(18);
		
		levelOrderTraversal(root);
	}
}
