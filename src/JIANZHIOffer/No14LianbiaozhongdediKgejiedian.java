package JIANZHIOffer;

public class No14LianbiaozhongdediKgejiedian {
    public ListNode FindKthToTail(ListNode head, int k) {
        ListNode m=head;
        int count=0;
        while(m!=null){
            count++;
            m=m.next;
        }
        if(count<k) return null;

        ListNode n=head;
        for(int i=0;i<count-k;i++){
            n=n.next;
        }
        return n;
    }

    public ListNode FindKthToTail2(ListNode head, int k) {
        if (head == null || k == 0) {
            return null;
        }
        ListNode tmp=head;
        for (int i = 0; i < k - 1; i++) {
            if (tmp.next != null) {
                tmp = tmp.next;
            } else {
                return null;
            }
        }
        ListNode pA=head;
        ListNode pB=head;
        for (int i = 0; i < k - 1; i++) {
            pA=pA.next;
            while (pA.next != null) {
                pA=pA.next;
                pB=pB.next;
            }

        }
        return pB;
    }
}
