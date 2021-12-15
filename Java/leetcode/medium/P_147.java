package leetcode.medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import utils.DataStructures.ListNode;

@SuppressWarnings("ConstantConditions")
public class P_147 {

    public ListNode insertionSortList(ListNode head) {
        final Map<Integer, Deque<ListNode>> map = new HashMap<>();
        final List<Integer> list = new ArrayList<>();
        for (ListNode iter = head; iter != null; iter = iter.next) {
            map.computeIfAbsent(iter.val, val -> new ArrayDeque<>()).addFirst(iter);
            list.add(iter.val);
        }
        list.sort(Comparator.naturalOrder());
        final ListNode res = new ListNode(-1);
        ListNode iter = res;
        for (int num : list) {
            final ListNode pop = map.get(num).removeFirst();
            iter.next = pop;
            pop.next = null;
            iter = iter.next;
        }
        return res.next;
    }
}
