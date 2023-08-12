package Y2023.M08;

import common.ListNode;
import org.junit.jupiter.api.Test;

import java.util.PriorityQueue;

public class MergeKLists {

	class Status implements Comparable<Status> {
		int val;
		ListNode ptr;

		Status(int val, ListNode ptr) {
			this.val = val;
			this.ptr = ptr;
		}

		public int compareTo(Status status2) {
			return this.val - status2.val;
		}
	}

	public ListNode mergeKLists(ListNode[] lists) {
		PriorityQueue<Status> priorityQueue = new PriorityQueue<>();
		for (int i = 0; i < lists.length; i++) {
			if(lists[i] == null) {
				continue;
			}
			priorityQueue.add(new Status(lists[i].val,lists[i]));
		}
		ListNode res = new ListNode(-1);
		ListNode curr = res;

		while(!priorityQueue.isEmpty()) {
			Status poll = priorityQueue.poll();
			curr.next = poll.ptr;
			curr = curr.next;
			if(poll.ptr.next == null) {
				continue;
			}
			poll.ptr = poll.ptr.next;
			priorityQueue.add(new Status(poll.ptr.val,poll.ptr));
		}
		return res.next;
	}

	@Test
	public void test() {
		MergeKLists mergeKLists = new MergeKLists();
		mergeKLists.mergeKLists(new ListNode[] {
				ListNode.convert("[1,4,5]"),
				ListNode.convert("[1,3,4]"),
				ListNode.convert("[2,6]")
		});

	}
}
