package megha.codingproblems.lists;
/**
 * Program to merge 2 sorted Linked Lists
 * Time complexity - O(m+n) where m and n are the sizes of the 2 linked lists
 * Space complexity - O(1)
 * 
 * @author megha krishnamurthy
 *
 */
public class MergeSortedLinkedList {
	
	/**
	 * This method takes the head nodes of 2 sorted linked lists and returns the head node of the merged list
	 * @param a
	 * @param b
	 * @return
	 */
	public ListNode merge(ListNode a, ListNode b) {
		ListNode result = new ListNode(0);
		ListNode current = result;
		while(a != null || b != null) {
			if(a != null && b != null) {
				if(a.data < b.data) {
					current.next = a;
					a = a.next;
				} else {
					current.next = b;
					b = b.next;
				}
				current = current.next;
			} else if(a == null) {
				current.next = b;
				break;
			} else if(b == null) {
				current.next = a;
			}
		}
		return result.next;
	}
	
	/*
	 * Private utility method to setup data for list A
	 */
	private ListNode setupListA() {
		ListNode head = new ListNode(12);
		ListNode second = new ListNode(14);
		ListNode third = new ListNode(18);
		ListNode fourth = new ListNode(22);
		head.next = second;
		second.next = third;
		third.next = fourth;
		
		return head;
	}
	
	/*
	 * Private utility method to setup data for list A
	 */
	private ListNode setupListB() {
		ListNode head = new ListNode(11);
		ListNode second = new ListNode(19);
		ListNode third = new ListNode(25);
		ListNode fourth = new ListNode(26);
		ListNode fifth = new ListNode(30);
		head.next = second;
		second.next = third;
		third.next = fourth;
		fourth.next = fifth;
		
		return head;
	}
	
	/*
	 * Private utility method to print the contents of a linked list
	 */
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
	
	public static void main(String args[]) {
		MergeSortedLinkedList mergeList = new MergeSortedLinkedList();
		ListNode a = mergeList.setupListA();
		ListNode b = mergeList.setupListB();
		
		ListNode result = mergeList.merge(a, b);
		mergeList.printList(result);
		
	}
}
