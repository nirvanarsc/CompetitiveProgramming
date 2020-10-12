package leetcode.weekly_contests.weekly_151;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.PriorityQueue;

public class P_1172 {

    static class DinnerPlates {
        List<Deque<Integer>> list;
        PriorityQueue<Integer> priority;
        int cap;

        DinnerPlates(int capacity) {
            list = new ArrayList<>();
            priority = new PriorityQueue<>();
            cap = capacity;
        }

        public void push(int val) {
            if (!priority.isEmpty() && priority.peek() >= list.size()) {
                priority.clear();
            }
            if (priority.isEmpty()) {
                if (list.isEmpty() || list.get(list.size() - 1).size() == cap) {
                    list.add(new ArrayDeque<>());
                }
                list.get(list.size() - 1).addFirst(val);
            } else {
                list.get(priority.poll()).addFirst(val);
            }
        }

        public int pop() {
            while (!list.isEmpty() && list.get(list.size() - 1).isEmpty()) {
                list.remove(list.size() - 1);
            }
            if (list.isEmpty()) {
                return -1;
            }
            return list.get(list.size() - 1).removeFirst();
        }

        public int popAtStack(int index) {
            if (index >= list.size() || list.get(index).isEmpty()) {
                return -1;
            }
            priority.add(index);
            return list.get(index).removeFirst();
        }
    }
}
