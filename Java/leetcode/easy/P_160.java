package leetcode.easy;

import utils.DataStructures.ListNode;

@SuppressWarnings("ReturnOfNull")
public class P_160 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode iterA = headA;
        ListNode iterB = headB;
        int reset = 0;
        while (reset < 2) {
            iterA = iterA.next;
            iterB = iterB.next;
            if (iterA == null) {
                iterA = headB;
                reset++;
            }
            if (iterB == null) {
                iterB = headA;
                reset++;
            }
        }
        while (iterA != iterB) {
            iterA = iterA.next;
            iterB = iterB.next;
        }
        return iterA;
    }
}
