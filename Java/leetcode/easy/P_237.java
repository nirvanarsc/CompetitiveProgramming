package leetcode.easy;

import utils.DataStructures.ListNode;

public class P_237 {

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
