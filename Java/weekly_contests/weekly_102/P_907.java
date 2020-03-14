package weekly_contests.weekly_102;

import java.util.ArrayDeque;
import java.util.Deque;

public class P_907 {

    private static final int MOD = (int) (1e9 + 7);

    @SuppressWarnings("MethodParameterNamingConvention")
    public int sumSubarrayMins(int[] A) {
        final Deque<int[]> stack1 = new ArrayDeque<>();
        final Deque<int[]> stack2 = new ArrayDeque<>();
        final int[] left = new int[A.length];
        final int[] right = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            int curr = 1;
            while (!stack1.isEmpty() && stack1.peekFirst()[0] > A[i]) {
                curr += stack1.removeFirst()[1];
            }
            stack1.addFirst(new int[] { A[i], curr });
            left[i] = curr;
        }
        for (int i = A.length - 1; i >= 0; i--) {
            int curr = 1;
            while (!stack2.isEmpty() && stack2.peekFirst()[0] >= A[i]) {
                curr += stack2.removeFirst()[1];
            }
            stack2.addFirst(new int[] { A[i], curr });
            right[i] = curr;
        }
        int res = 0;
        for (int i = 0; i < A.length; i++) {
            res = (res + left[i] * right[i] * A[i]) % MOD;
        }
        return res;
    }
}
