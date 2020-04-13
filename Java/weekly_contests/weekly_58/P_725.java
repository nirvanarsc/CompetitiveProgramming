package weekly_contests.weekly_58;

import java.util.Arrays;

import utils.DataStructures.ListNode;

public class P_725 {

    @SuppressWarnings("ConstantConditions")
    public ListNode[] splitListToParts(ListNode root, int k) {
        final int[] sizes = new int[k];
        final int l = getLength(root);
        final int d = l / k;
        final int diff = l - d * k;
        Arrays.fill(sizes, d);
        for (int i = 0; i < diff; i++) {
            sizes[i]++;
        }
        final ListNode[] res = new ListNode[k];
        ListNode iter = root;
        for (int i = 0; i < k; i++) {
            if (sizes[i] == 0) {
                break;
            }
            final ListNode head = iter;
            while (sizes[i]-- > 1) {
                iter = iter.next;
            }
            final ListNode t = iter.next;
            iter.next = null;
            iter = t;
            res[i] = head;
        }
        return res;
    }

    private static int getLength(ListNode n) {
        if (n == null) { return 0; }
        return 1 + getLength(n.next);
    }
}
