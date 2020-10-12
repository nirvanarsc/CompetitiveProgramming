package leetcode.weekly_contests.weekly_68;

public class P_768 {

    public int maxChunksToSorted(int[] arr) {
        final int n = arr.length;
        final int[] minOfRight = new int[n];
        minOfRight[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            minOfRight[i] = Math.min(minOfRight[i + 1], arr[i]);
        }
        int res = 1;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n - 1; i++) {
            max = Math.max(max, arr[i]);
            if (max <= minOfRight[i + 1]) {
                res++;
            }
        }
        return res;
    }
}
