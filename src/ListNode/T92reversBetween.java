package ListNode;

public class T92reversBetween {
	//翻转链表
	public ListNode reverseBetween(ListNode head, int m, int n) {
		// 头插法
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode pre = head;
		ListNode cur = dummy.next;
		for (int i = 1; i < m; i++) {
			pre = pre.next;
			cur = cur.next;
		}

		for (int i = 0; i < n - m; i++) {
			ListNode tmp = cur.next;
			cur.next = tmp.next;
			tmp.next = pre.next;
			pre.next = tmp;
		}
		return dummy.next;
	}

	public ListNode reverseBetween2(ListNode head, int m, int n) {
		if (head == null || head.next == null)
			return head;
		ListNode curHead = new ListNode(0);
		curHead.next = head;
		int index = 1;
		ListNode pre = head;
		ListNode cur = head.next;
		ListNode next;
		ListNode last = head;
		ListNode first = curHead;
		while (index < n) {
			if (index >= m && index <= n) {
				while (index < n) {
					next = cur.next;
					cur.next = pre;
					pre = cur;
					cur = next;
					index++;
				}
			} else if (index < m) {
				first = first.next;
				pre = pre.next;
				cur = cur.next;
				last = pre;
				index++;
			}
		}
		first.next = pre;
		last.next = cur;
		return curHead.next;

	}
}
