package weekly_contests.weekly_61;

import java.util.ArrayDeque;
import java.util.Deque;

public class P_739 {

    @SuppressWarnings("MethodParameterNamingConvention")
    public int[] dailyTemperatures(int[] T) {
        final Deque<Integer> stack = new ArrayDeque<>();
        final int[] res = new int[T.length];
        for (int i = T.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && T[i] >= T[stack.peekFirst()]) {
                stack.removeFirst();
            }
            res[i] = stack.isEmpty() ? 0 : stack.getFirst() - i;
            stack.addFirst(i);
        }
        return res;
    }
}
