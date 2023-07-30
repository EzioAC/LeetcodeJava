package Y2023.M07;

import common.ListNode;

public class DetectCycle {
	public ListNode detectCycle(ListNode head) {
		ListNode fastPointer = head;
		ListNode slowPointer = head;
		ListNode slowPointer2 = null;
		while(true) {
			if(fastPointer == null || fastPointer.next == null) {
				return null;
			}
			if(slowPointer2 == slowPointer) {
				return slowPointer2;
			}
			if(slowPointer2 != null) {
				slowPointer2 = slowPointer2.next;
			}
			fastPointer = fastPointer.next.next;
			slowPointer = slowPointer.next;
			if(slowPointer == fastPointer && slowPointer2!= null) {
				slowPointer2 = head;
			}
		}
	}
}
