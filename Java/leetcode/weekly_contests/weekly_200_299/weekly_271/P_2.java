package leetcode.weekly_contests.weekly_200_299.weekly_271;

import java.util.ArrayDeque;
import java.util.Deque;

public class P_2 {

    public long subArrayRanges(int[] nums) {
        return sumSubarrayMax(nums) - sumSubarrayMin(nums);
    }

    private static long sumSubarrayMin(int[] arr) {
        final Deque<int[]> dq = new ArrayDeque<>();
        final int n = arr.length;
        final int[] left = new int[n];
        final int[] right = new int[n];
        for (int i = 0; i < n; i++) {
            int curr = 1;
            while (!dq.isEmpty() && dq.peekFirst()[0] > arr[i]) {
                curr += dq.removeFirst()[1];
            }
            dq.addFirst(new int[] { arr[i], curr });
            left[i] = curr;
        }
        dq.clear();
        for (int i = n - 1; i >= 0; i--) {
            int curr = 1;
            while (!dq.isEmpty() && dq.peekFirst()[0] >= arr[i]) {
                curr += dq.removeFirst()[1];
            }
            dq.addFirst(new int[] { arr[i], curr });
            right[i] = curr;
        }
        long res = 0;
        for (int i = 0; i < n; i++) {
            res += (long) left[i] * right[i] * arr[i];
        }
        return res;
    }

    private static long sumSubarrayMax(int[] arr) {
        final Deque<int[]> dq = new ArrayDeque<>();
        final int n = arr.length;
        final int[] left = new int[n];
        final int[] right = new int[n];
        for (int i = 0; i < n; i++) {
            int curr = 1;
            while (!dq.isEmpty() && dq.peekFirst()[0] < arr[i]) {
                curr += dq.removeFirst()[1];
            }
            dq.addFirst(new int[] { arr[i], curr });
            left[i] = curr;
        }
        dq.clear();
        for (int i = n - 1; i >= 0; i--) {
            int curr = 1;
            while (!dq.isEmpty() && dq.peekFirst()[0] <= arr[i]) {
                curr += dq.removeFirst()[1];
            }
            dq.addFirst(new int[] { arr[i], curr });
            right[i] = curr;
        }
        long res = 0;
        for (int i = 0; i < n; i++) {
            res += (long) left[i] * right[i] * arr[i];
        }
        return res;
    }
}
