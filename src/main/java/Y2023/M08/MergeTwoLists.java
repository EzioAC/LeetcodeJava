package Y2023.M08;

import common.ListNode;
import org.junit.jupiter.api.Test;

public class MergeTwoLists {
	public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
		ListNode resPointer = new ListNode(0);
		ListNode curr = resPointer;
		while(true) {
			if(list1 == null) {
				curr.next = list2;
				break;
			}
			if(list2 == null) {
				curr.next = list1;
				break;
			}
			if(list1.val <= list2.val) {
				curr.next = list1;
				list1 = list1.next;
			} else {
				curr.next = list2;
				list2 = list2.next;
			}
			curr = curr.next;
		}
		return resPointer.next;
	}

	@Test
	public void test() {
		MergeTwoLists mergeTwoLists = new MergeTwoLists();
		ListNode listNode = mergeTwoLists.mergeTwoLists(
				ListNode.convert("[1,2,4]"),
				ListNode.convert("[1,3,4]")
		);
		System.out.println(listNode);
	}

	@Test
	public void test2() {
		MergeTwoLists mergeTwoLists = new MergeTwoLists();
		ListNode listNode = mergeTwoLists.mergeTwoLists(
				ListNode.convert("[]"),
				ListNode.convert("[]")
		);
		System.out.println(listNode);
	}

	@Test
	public void test3() {
		MergeTwoLists mergeTwoLists = new MergeTwoLists();
		ListNode listNode = mergeTwoLists.mergeTwoLists(
				ListNode.convert("[]"),
				ListNode.convert("[0]")
		);
		System.out.println(listNode);
	}


}
