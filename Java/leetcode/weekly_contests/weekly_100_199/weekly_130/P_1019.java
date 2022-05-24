package leetcode.weekly_contests.weekly_100_199.weekly_130;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import utils.DataStructures.ListNode;

public class P_1019 {

    public int[] nextLargerNodes(ListNode head) {
        final List<Integer> list = new ArrayList<>();
        for (ListNode iter = head; iter != null; iter = iter.next) {
            list.add(iter.val);
        }
        final int[] res = new int[list.size()];
        final Deque<Integer> stack = new ArrayDeque<>();
        for (int i = list.size() - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peekFirst() <= list.get(i)) {
                stack.removeFirst();
            }
            res[i] = stack.isEmpty() ? 0 : stack.peekFirst();
            stack.addFirst(list.get(i));
        }
        return res;
    }
}
