package leetcode.weekly_contests.weekly_0_99.weekly_91;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.Map;
import java.util.TreeMap;

@SuppressWarnings("MethodParameterNamingConvention")
public class P_862 {

    // Similar to LC 363
    public int shortestSubarrayTreeMap(int[] A, int K) {
        final TreeMap<Integer, Integer> preSum = new TreeMap<>(Collections.singletonMap(0, -1));
        int minLen = Integer.MAX_VALUE;
        int curSum = 0;
        for (int i = 0; i < A.length; i++) {
            curSum += A[i];
            Map.Entry<Integer, Integer> entry = preSum.floorEntry(curSum - K);
            while (entry != null) {
                final int key = entry.getKey();
                minLen = Math.min(minLen, i - entry.getValue());
                preSum.remove(key);
                entry = preSum.floorEntry(key);
            }
            preSum.put(curSum, i);
        }
        return (minLen == Integer.MAX_VALUE) ? -1 : minLen;
    }

    public int shortestSubarray(int[] nums, int k) {
        final int n = nums.length;
        int res = n + 1;
        final long[] prefixSum = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
        }
        final Deque<Integer> d = new ArrayDeque<>();
        for (int i = 0; i < n + 1; i++) {
            while (!d.isEmpty() && prefixSum[i] - prefixSum[d.getFirst()] >= k) {
                res = Math.min(res, i - d.removeFirst());
            }
            while (!d.isEmpty() && prefixSum[i] <= prefixSum[d.getLast()]) {
                d.removeLast();
            }
            d.addLast(i);
        }
        return res == n + 1 ? -1 : res;
    }

    public int shortestSubarrayEPI(int[] A, int K) {
        final int N = A.length;
        final int[] prefixMinSum = new int[N];
        prefixMinSum[N - 1] = A[N - 1];
        for (int i = N - 2; i >= 0; i--) {
            prefixMinSum[i] = prefixMinSum[i + 1] < 0 ? prefixMinSum[i + 1] + A[i] : A[i];
        }
        int len = N + 1;
        int sum = 0, i = 0;
        for (int j = 0; j < N; j++) {
            sum += A[j];
            while (i < j && sum - prefixMinSum[i] >= K) {
                sum -= A[i++];
            }
            if (sum >= K) {
                len = Math.min(len, j - i + 1);
            }
        }
        return len == N + 1 ? -1 : len;
    }
}
