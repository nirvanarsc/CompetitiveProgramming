package medium;

import utils.DataStructures.ListNode;

@SuppressWarnings("ConstantConditions")
public class P_328 {

    public ListNode oddEvenList(ListNode head) {
        final ListNode odds = new ListNode(-1);
        ListNode oddsIter = odds;
        ListNode iter = head;
        while (iter != null) {
            if (iter.next == null) {
                iter.next = odds.next;
                break;
            }
            final ListNode oddNode = iter.next;
            iter.next = iter.next.next;
            oddNode.next = null;
            oddsIter.next = oddNode;
            oddsIter = oddsIter.next;
            if (iter.next == null) {
                iter.next = odds.next;
                break;
            }
            iter = iter.next;
        }
        return head;
    }
}
