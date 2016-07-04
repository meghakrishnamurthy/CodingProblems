package megha.codingproblem.trees;

/**
 * Class to represent the node of a binary tree
 * @author megha krishnamurthy
 *
 */
public class Node {
	int data;
	Node left;
	Node right;
	
	public Node(int value) {
		data = value;
		left = right = null;
	}
}