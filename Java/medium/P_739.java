package medium;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class P_739 {

    public int[] dailyTemperaturesStack(int[] T) {
        final int[] res = new int[T.length];
        final Deque<Integer> stack = new LinkedList<>();
        for (int i = T.length - 1; i >= 0; --i) {
            while (!stack.isEmpty() && T[i] >= T[stack.peekFirst()]) {
                stack.removeFirst();
            }
            res[i] = stack.isEmpty() ? 0 : stack.peekFirst() - i;
            stack.addFirst(i);
        }
        return res;
    }

    public int[] dailyTemperatures(int[] T) {
        final int[] res = new int[T.length];
        final Map<Integer, Integer> map = new HashMap<>();
        for (int i = T.length - 1; i >= 0; i--) {
            int val = Integer.MAX_VALUE;
            for (int j = T[i] + 1; j <= 100; j++) {
                if (map.containsKey(j)) {
                    val = Math.min(val, map.get(j) - i);
                }
            }
            res[i] = val == Integer.MAX_VALUE ? 0 : val;
            map.put(T[i], i);
        }
        return res;
    }
}
