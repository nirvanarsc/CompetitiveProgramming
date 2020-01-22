package medium;

import java.util.HashSet;
import java.util.Set;

import utils.DataStructures.ListNode;

public class P_817 {

    public int numComponents(ListNode head, int[] G) {
        final Set<Integer> set = new HashSet<>();
        for (int i : G) {
            set.add(i);
        }
        int res = 0;
        while (head != null) {
            if (set.contains(head.val) && (head.next == null || !set.contains(head.next.val))) {
                res++;
            }
            head = head.next;
        }
        return res;
    }
}
