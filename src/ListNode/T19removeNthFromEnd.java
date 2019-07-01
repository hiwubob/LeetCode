package ListNode;

public class T19removeNthFromEnd {
	public ListNode removeNthFromEnd(ListNode head, int n) {
//		删除链表的倒数第N个节点 Medium
		//双指针
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode first = dummy;
		ListNode second = dummy;
		for (int i = 0; i <= n; i++) {
			first = first.next;//快指针领先n步
		}
		while (first != null) {
			first = first.next;//快慢指针一起走
			second = second.next;
		}
		second.next = second.next.next;//将待删除的跳过
		return dummy.next;
	}
}
