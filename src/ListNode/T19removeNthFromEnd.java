package ListNode;

public class T19removeNthFromEnd {
	public ListNode removeNthFromEnd(ListNode head, int n) {
//		ɾ������ĵ�����N���ڵ� Medium
		//˫ָ��
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode first = dummy;
		ListNode second = dummy;
		for (int i = 0; i <= n; i++) {
			first = first.next;//��ָ������n��
		}
		while (first != null) {
			first = first.next;//����ָ��һ����
			second = second.next;
		}
		second.next = second.next.next;//����ɾ��������
		return dummy.next;
	}
}
