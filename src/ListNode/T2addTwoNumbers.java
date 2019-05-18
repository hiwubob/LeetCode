package ListNode;

public class T2addTwoNumbers {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if (l1 == null || l2 == null) {
			return l1 == null ? l2 : l1;
		}
		int carry = 0;
		ListNode resNode = new ListNode(-1);
		ListNode head = resNode;
		while (l1 != null || l2 != null) {
			int sum = carry;
			if (l1 != null) {
				sum += l1.val;
				l1 = l1.next;
			}
			if (l2 != null) {
				sum += l2.val;
				l2 = l2.next;
			}

			carry = sum / 10;
			sum %= 10;
			resNode.next = new ListNode(sum);
			resNode = resNode.next;
		}

		if (carry != 0) {
			resNode.next = new ListNode(carry);
		}

		return head.next;
	}
}
