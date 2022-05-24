package leetcode.weekly_contests.weekly_0_99.weekly_58;

import java.util.Arrays;

import utils.DataStructures.ListNode;

public class P_725 {

    public ListNode[] splitListToParts(ListNode head, int k) {
        final int[] size = new int[k];
        final int l = getLength(head);
        final int d = l / k;
        final int diff = l - d * k;
        Arrays.fill(size, d);
        for (int i = 0; i < diff; i++) {
            size[i]++;
        }
        final ListNode[] res = new ListNode[k];
        ListNode iter = head;
        for (int i = 0; i < k && size[i] > 0; i++) {
            final ListNode curr = iter;
            for (int j = 1; j < size[i]; j++) {
                iter = iter.next;
            }
            final ListNode temp = iter.next;
            //noinspection ConstantConditions
            iter.next = null;
            iter = temp;
            res[i] = curr;
        }
        return res;
    }

    private static int getLength(ListNode n) {
        if (n == null) { return 0; }
        return 1 + getLength(n.next);
    }
}
