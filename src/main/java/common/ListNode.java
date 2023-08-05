package common;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

public class ListNode {
	public int val;
	public ListNode next;

	public ListNode(int x) {
		val = x;
		next = null;
	}

	public static ListNode convert(String str) {
		List<Integer> integers = JSON.parseArray(str, Integer.class);
		ListNode head = null;
		ListNode curr = head;
		for (Integer integer : integers) {
			if(head == null) {
				head = new ListNode(integer);
				curr = head;
			} else {
				curr.next = new ListNode(integer);
				curr = curr.next;
			}
		}
		return head;
	}

	public static String convert(ListNode head) {
		ArrayList<Integer> list = new ArrayList<>();
		while (head != null) {
			list.add(head.val);
			head = head.next;
		}
		return JSON.toJSONString(list);
	}

	@Override
	public String toString() {
		ArrayList<Integer> list = new ArrayList<>();
		ListNode head = this;
		while (head != null) {
			list.add(head.val);
			head = head.next;
		}
		return JSON.toJSONString(list);
	}
}