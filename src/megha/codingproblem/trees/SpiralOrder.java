package megha.codingproblem.trees;

public class SpiralOrder {
	public void printSpiralOrder(Node node) {
		int height = height(node);
		boolean ltr = false;
		for(int i=1; i<=height; i++) {
			printGivenLevel(node, ltr, i);
			ltr = !ltr;
		}
	}
	
	private int height(Node node) {
		if(node == null) {
			return 0;
		}
		
		int lHeight = height(node.left);
		int rHeight = height(node.right);
		if(lHeight > rHeight) {
			return lHeight + 1;
		} else {
			return rHeight + 1;
		}
	}
	
	private void printGivenLevel(Node node, boolean ltr, int level) {
		if(node == null) {
			 return;
		}
		if(level == 1) {
			System.out.print(node.data + " ");
		} else if(level > 1) {
			if(ltr == true) {
				printGivenLevel(node.left, ltr, level-1);
				printGivenLevel(node.right, ltr, level-1);
			} else {
				printGivenLevel(node.right, ltr, level-1);
				printGivenLevel(node.left, ltr, level-1);
			}
		}
	}
	
	public static void main(String args[]) {
		BinaryTree tree = new BinaryTree();
		Node root = tree.populateBinaryTree();
		
		SpiralOrder spOrder = new SpiralOrder();
		spOrder.printSpiralOrder(root);
	}
}
