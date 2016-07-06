package megha.codingproblems.lists;

public class ReverseLinkedList {
	private static ListNode head;
	
	public ListNode reverseLinkedList(ListNode head) {
		if(head == null || head.next == null) {
			return head;
		}
		
		ListNode second = head.next;
		ListNode third = second.next;
		head.next = null;
		second.next = head;
		
		if(third == null) {
			return second;
		}
		
		ListNode currentNode = third;
		ListNode prevNode = second;
		
		while(currentNode != null) {
			ListNode nextNode = currentNode.next;
			currentNode.next = prevNode;
			
			prevNode = currentNode;
			currentNode = nextNode;
		}
		return prevNode;
	}
	
	public void recursiveReverse(ListNode currentNode) {
		if(currentNode == null) {
			return;
		}
		
		if(currentNode.next == null) {
			head = currentNode;
			return;
		}
		
		recursiveReverse(currentNode.next);
		currentNode.next.next = currentNode;
		currentNode.next = null;
	}
	
	private void printList(ListNode head) {
		if(head == null) {
			return;
		}
		
		ListNode currentNode = head;
		while(currentNode != null) {
			System.out.println(currentNode.data);
			currentNode = currentNode.next;
		}
 	}
	
	private ListNode setupData() {
		ListNode head = new ListNode(12);
		ListNode second = new ListNode(4);
		ListNode third = new ListNode(18);
		ListNode fourth = new ListNode(22);
		head.next = second;
		second.next = third;
		third.next = fourth;
		
		return head;
	}
	
	public static void main(String args[]) {
		ReverseLinkedList reverseList = new ReverseLinkedList();
		ListNode head1 = reverseList.setupData();
		ListNode newHead = reverseList.reverseLinkedList(head1);
		reverseList.printList(newHead);
		
		head = reverseList.setupData();
		reverseList.recursiveReverse(head);
		reverseList.printList(head);
		 
	}
}

class ListNode {
	int data;
	ListNode next;
	
	ListNode(int data) {
		this.data = data;
		this.next = null;
	}
}