package leetcode.weekly_contests.weekly_0_99.weekly_99;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

@SuppressWarnings({ "unused", "InnerClassMayBeStatic", "PublicConstructorInNonPublicClass" })
public class P_895 {

    class FreqStack {
        Map<Integer, Integer> freq;
        Map<Integer, Deque<Integer>> stack;
        int maxFreq;

        public FreqStack() {
            freq = new HashMap<>();
            stack = new HashMap<>();
        }

        public void push(int x) {
            final int k = freq.merge(x, 1, Integer::sum);
            stack.computeIfAbsent(k, v -> new ArrayDeque<>()).addFirst(x);
            maxFreq = Math.max(maxFreq, k);
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


