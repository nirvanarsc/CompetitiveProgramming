package weekly_145;

import java.util.ArrayDeque;
import java.util.Deque;

public class P_1124 {

    public int longestWPI(int[] hours) {
        final int len = hours.length;
        final int[] prefixSum = new int[len + 1];
        for (int i = 1; i <= len; ++i) {
            prefixSum[i] = prefixSum[i - 1] + (hours[i - 1] > 8 ? 1 : -1);
        }
        final Deque<Integer> smdStack = new ArrayDeque<>();
        for (int i = 0; i <= len; ++i) {
            if (smdStack.isEmpty() || prefixSum[smdStack.peekFirst()] > prefixSum[i]) {
                smdStack.addFirst(i);
            }
        }
        int res = 0;
        for (int j = len; j >= 0; --j) {
            while (!smdStack.isEmpty() && prefixSum[smdStack.peekFirst()] < prefixSum[j]) {
                res = Math.max(res, j - smdStack.peekFirst());
                smdStack.removeFirst();
            }
        }
        return res;
    }
}
