package leetcode.easy;

import java.util.HashSet;
import java.util.Set;

import utils.DataStructures.ListNode;

public class P_160 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA;
        ListNode b = headB;

        while (a != b) {
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }

        return a;
    }

    public ListNode getIntersectionSpace(ListNode headA, ListNode headB) {
        final Set<ListNode> seen = new HashSet<>();
        while (headA != null && headB != null) {
            if (!seen.add(headA)) {
                return headA;
            }
            if (!seen.add(headB)) {
                return headB;
            }
            headA = headA.next;
            headB = headB.next;
        }
        while (headB != null) {
            if (!seen.add(headB)) {
                return headB;
            }
            headB = headB.next;
        }
        while (headA != null) {
            if (!seen.add(headA)) {
                return headA;
            }
            headA = headA.next;
        }
        return null;
    }
}
