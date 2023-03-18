package leetcode.biweekly_contests.biweekly_0_99.biweekly_57;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class P_4 {

    public int[] canSeePersonsCount(int[] arr) {
        final int n = arr.length;
        final int[] res = new int[n];
        final Deque<Integer> dq = new ArrayDeque<>();
        Arrays.fill(res, 1);
        res[n - 1] = 0;
        for (int i = 0; i < n; i++) {
            while (!dq.isEmpty() && arr[dq.getFirst()] < arr[i]) {
                dq.removeFirst();
                if (!dq.isEmpty()) {
                    res[dq.getFirst()]++;
                }
            }
            dq.addFirst(i);
        }
        return res;
    }
}
