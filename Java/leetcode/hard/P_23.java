package leetcode.hard;

import java.util.Comparator;
import java.util.PriorityQueue;

import utils.DataStructures.ListNode;

public class P_23 {

    public ListNode mergeKLists(ListNode[] lists) {
        final PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(a -> lists[a].val));
        final int n = lists.length;
        for (int i = 0; i < n; i++) {
            if (lists[i] != null) {
                pq.offer(i);
            }
        }
        final ListNode res = new ListNode(-1);
        ListNode iter = res;
        while (!pq.isEmpty()) {
            final int curr = pq.remove();
            iter.next = lists[curr];
            iter = iter.next;
            lists[curr] = lists[curr].next;
            if (lists[curr] != null) {
                pq.offer(curr);
            }
        }
        return res.next;
    }
}
