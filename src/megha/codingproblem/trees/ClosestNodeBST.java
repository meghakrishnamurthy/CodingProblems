package megha.codingproblem.trees;

/**
 * Solution to the problem of finding the closest node in a BST for a given value
 * Time complexity - Average case of O(logn) and worst case of O(n)
 * Space complexity - O(h) where h is the height of the tree with worst case being O(n)
 * 
 * @author megha krishnamurthy
 *
 */
public class ClosestNodeBST {

	/**
	 * Method finds the closest node to a given value in a BST
	 * @param root
	 * @param value
	 * @return
	 */
	public Node findClosestNode(Node root, int value) {
		if(root == null) {
			return null;
		}
		Node closestNode = null;
		int minDistance = Math.abs(root.data-value);
		Node currentNode = root;
		
		while(currentNode != null) {
			int distance = Math.abs(currentNode.data - value);
			if(distance < minDistance) {
				minDistance = distance;
				closestNode = currentNode;
			}
			
			if(distance == 0) {
				break;
			}
			
			if(currentNode.data > value) {
				currentNode = currentNode.left;
			} else if(currentNode.data < value) {
				currentNode = currentNode.right;
			}
			
		}
		return closestNode;
	}
	
	public static void main(String args[]) {
		BinaryTree tree = new BinaryTree();
		Node root = tree.populateBinaryTree();
		
		ClosestNodeBST closestNodeBst = new ClosestNodeBST();
		Node closestNode = closestNodeBst.findClosestNode(root, 19);
		if(closestNode != null) {
			System.out.println(closestNode.data);
		}
	}
}
