package weekly_contests.weekly_101;

import java.util.ArrayDeque;
import java.util.Deque;

public class P_900 {

    static class RLEIterator {
        Deque<int[]> stack;

        @SuppressWarnings("MethodParameterNamingConvention")
        RLEIterator(int[] A) {
            stack = new ArrayDeque<>();
            for (int i = 0; i < A.length; i += 2) {
                if (A[i] != 0) {
                    stack.addLast(new int[] { A[i], A[i + 1] });
                }
            }
        }

        public int next(int n) {
            while (!stack.isEmpty() && n > stack.peekFirst()[0]) {
                n -= stack.removeFirst()[0];
            }
            if (stack.isEmpty()) {
                return -1;
            }
            stack.peekFirst()[0] -= n;
            return stack.peekFirst()[1];
        }
    }
}
