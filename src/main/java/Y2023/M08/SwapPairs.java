package Y2023.M08;

import common.ListNode;
import org.junit.jupiter.api.Test;

public class SwapPairs {
	public ListNode swapPairs(ListNode head) {
		ListNode resPointer = new ListNode(0);
		resPointer.next = head;
		ListNode curr = resPointer;
		while(curr != null) {
			if(curr.next == null || curr.next.next == null) {
				break;
			}
			ListNode temp = curr.next;
			curr.next = curr.next.next;
			temp.next = curr.next.next;
			curr.next.next = temp;
			curr = curr.next.next;
		}
		return resPointer.next;
	}

	@Test
	public void test() {
		SwapPairs swapPairs = new SwapPairs();
		System.out.println(
				swapPairs.swapPairs(ListNode.convert("[1,2,3,4]"))
		);
	}

	@Test
	public void test1() {
		SwapPairs swapPairs = new SwapPairs();
		System.out.println(
				swapPairs.swapPairs(ListNode.convert("[]"))
		);
	}

	@Test
	public void test2() {
		SwapPairs swapPairs = new SwapPairs();
		System.out.println(
				swapPairs.swapPairs(ListNode.convert("[1]"))
		);
	}
}
