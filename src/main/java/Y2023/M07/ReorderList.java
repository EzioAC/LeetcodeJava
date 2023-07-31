package Y2023.M07;

import common.ListNode;

public class ReorderList {

	public static void main(String[] args) {
		ReorderList reorderList = new ReorderList();

		ListNode q1 = ListNode.convert("[1,2,3]");
		reorderList.reorderList(q1);
		System.out.println(ListNode.convert(q1));

		ListNode q2 = ListNode.convert("[1]");
		reorderList.reorderList(q1);
		System.out.println(ListNode.convert(q2));

		ListNode q3 = ListNode.convert("[]");
		reorderList.reorderList(q1);
		System.out.println(ListNode.convert(q3));

		ListNode q4 = ListNode.convert("[1,2,3,4]");
		reorderList.reorderList(q4);
		System.out.println(ListNode.convert(q4));


	}
	public void reorderList(ListNode head) {
		if(head == null) {
			return;
		}
		ListNode mid = findMid(head);
		ListNode reverse = reverse(mid);
		merge(head,reverse);
	}

	public ListNode findMid(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}

	public ListNode reverse(ListNode head) {
		ListNode prev = null;
		ListNode curr = head;
		while (curr != null) {
			ListNode nextTemp = curr.next;
			curr.next = prev;
			prev = curr;
			curr = nextTemp;
		}
		return prev;
	}

	public void merge(ListNode listNode1,ListNode listNode2) {
		ListNode temp1 = listNode1;
		ListNode temp2 = listNode2;
		while (listNode1 != null && listNode2 != null) {
			temp1 = listNode1.next;
			temp2 = listNode2.next;
			listNode1.next = listNode2;
			listNode1 = temp1;

			listNode2.next = listNode1;
			listNode2 = temp2;
		}
	}
}
