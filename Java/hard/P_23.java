package hard;

import java.util.Comparator;
import java.util.PriorityQueue;

import utils.DataStructures.ListNode;

public class P_23 {

    public ListNode mergeKLists(ListNode[] lists) {
        final PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));
        for (ListNode node : lists) {
            if (node != null) {
                pq.offer(node);
            }
        }
        final ListNode dummy = new ListNode(-1);
        ListNode iter = dummy;
        while (!pq.isEmpty()) {
            final ListNode remove = pq.remove();
            iter.next = remove;
            iter = iter.next;
            if (remove.next != null) {
                pq.offer(remove.next);
            }
        }
        return dummy.next;
    }
}
