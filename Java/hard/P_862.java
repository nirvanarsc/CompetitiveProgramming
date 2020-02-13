package hard;

import java.util.ArrayDeque;
import java.util.Deque;

public class P_862 {

    public int shortestSubarray(int[] A, int K) {
        final int N = A.length;
        int res = N + 1;
        final int[] prefixSum = new int[N + 1];
        for (int i = 0; i < N; i++) {
            prefixSum[i + 1] = prefixSum[i] + A[i];
        }
        final Deque<Integer> d = new ArrayDeque<>();
        for (int i = 0; i < N + 1; i++) {
            while (!d.isEmpty() && prefixSum[i] - prefixSum[d.getFirst()] >= K) {
                res = Math.min(res, i - d.pollFirst());
            }
            while (!d.isEmpty() && prefixSum[i] <= prefixSum[d.getLast()]) {
                d.pollLast();
            }
            d.addLast(i);
        }
        return res == N + 1 ? -1 : res;
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
