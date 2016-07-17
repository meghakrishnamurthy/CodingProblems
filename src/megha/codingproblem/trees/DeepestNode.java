package megha.codingproblem.trees;

/**
 * Program to find the deepest node in a Binary Tree
 * Take two global vari­able as “deep­estlevel” and “value”.
 * start­ing with level=0, Do the inorder tra­ver­sal and when­ever you go down one level ( root.left OR root.right), increase the level by 1.
 * Keep check­ing if deep­estlevel < level, if yes then update the “deep­estlevel ” and “value “.
 * At the end return “value”, which will the deep­est node value.
 * 
 * Time complexity - O(n)
 * Space complexity - O(n) if we consider the stack space else O(1)
 * 
 * @author megha krishnamurthy
 *
 */
public class DeepestNode {
	
	int deepestLevel;
	int value;
	
	public int deepestNode(Node root) {
		findDeepestNode(root, 0);
		return value;
	}
	
	public void findDeepestNode(Node node, int level) {
		if(node != null) {
			findDeepestNode(node.left, level++);
			if(level > deepestLevel) {
				deepestLevel = level;
				value = node.data;
			}
			findDeepestNode(node.right, level);
		}
	}
	
	public static void main(String args[]) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		root.right.right.right = new Node(8);
		
		DeepestNode deepNode = new DeepestNode();
		System.out.println(deepNode.deepestNode(root));
	}
}
