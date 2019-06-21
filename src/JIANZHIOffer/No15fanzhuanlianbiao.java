package JIANZHIOffer;

public class No15fanzhuanlianbiao {
    public ListNode ReverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode next=null;
        ListNode pre=null;
        while (head != null) {
            next = head.next;
            head.next=pre;
            pre=head;
            head=next;
        }
        return pre;
    }
}
