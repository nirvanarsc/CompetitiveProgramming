package weekly_151;

import java.util.HashMap;
import java.util.Map;

import utils.DataStructures.ListNode;

public class P_1171 {

    public ListNode removeZeroSumSublistsSimple(ListNode head) {
        final Map<Integer, ListNode> seen = new HashMap<>();
        final ListNode dummy = new ListNode(0);
        dummy.next = head;
        int prefix = 0;
        for (ListNode i = dummy; i != null; i = i.next) {
            prefix += i.val;
            seen.put(prefix, i);
        }
        prefix = 0;
        for (ListNode i = dummy; i != null; i = i.next) {
            prefix += i.val;
            i.next = seen.get(prefix).next;
        }
        return dummy.next;
    }

    public ListNode removeZeroSumSublists(ListNode head) {
        final Map<Integer, ListNode> map = new HashMap<>();
        final ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode iter = dummy;
        int sum = 0;
        while (iter != null) {
            sum += iter.val;
            if (map.containsKey(sum)) {
                iter = map.get(sum).next;
                int key = sum + iter.val;
                while (key != sum) {
                    map.remove(key);
                    iter = iter.next;
                    key += iter.val;
                }
                map.get(sum).next = iter.next;
            } else {
                map.put(sum, iter);
            }
            iter = iter.next;
        }
        return dummy.next;
    }
}
