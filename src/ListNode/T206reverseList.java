package ListNode;

public class T206reverseList {
	public ListNode reverseList(ListNode head) {
		ListNode next = null, pre = null;
		while (head != null) {
			next = head.next;
			head.next = pre;
			pre = head;
			head = next;
		}
		return pre;
	}
}
