package leetcode.weekly_contests.weekly_116;

import java.util.ArrayDeque;
import java.util.Deque;

public class P_962 {

    @SuppressWarnings("MethodParameterNamingConvention")
    public int maxWidthRamp(int[] A) {
        final Deque<Integer> stack = new ArrayDeque<>();
        int res = 0;
        for (int i = 0; i < A.length; ++i) {
            if (stack.isEmpty() || A[stack.peekFirst()] > A[i]) {
                stack.addFirst(i);
            }
        }
        for (int i = A.length - 1; i > res; --i) {
            while (!stack.isEmpty() && A[stack.peekFirst()] <= A[i]) {
                res = Math.max(res, i - stack.removeFirst());
            }
        }
        return res;
    }
}
