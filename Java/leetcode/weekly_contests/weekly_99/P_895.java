package leetcode.weekly_contests.weekly_99;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class P_895 {

    static class FreqStack {
        Map<Integer, Integer> freq;
        Map<Integer, Deque<Integer>> stack;
        int maxFreq;

        FreqStack() {
            freq = new HashMap<>();
            stack = new HashMap<>();
        }

        public void push(int x) {
            stack.computeIfAbsent(freq.getOrDefault(x, 0) + 1, v -> new ArrayDeque<>()).addFirst(x);
            freq.merge(x, 1, Integer::sum);
            maxFreq = Math.max(maxFreq, freq.get(x));
        }

        public int pop() {
            final Integer res = stack.get(maxFreq).removeFirst();
            freq.merge(res, -1, Integer::sum);
            if (stack.get(maxFreq).isEmpty()) {
                stack.remove(maxFreq--);
            }
            return res;
        }
    }
}


