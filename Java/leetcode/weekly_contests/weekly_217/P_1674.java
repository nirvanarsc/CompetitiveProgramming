package leetcode.weekly_contests.weekly_217;

public class P_1674 {

    public int minMoves(int[] nums, int limit) {
        final int n = nums.length;
        final int size = (int) (2e5 + 5);
        final int[] sweepLine = new int[size];
        for (int i = 0; i < n / 2; i++) {
            final int L = nums[i];
            final int R = nums[n - 1 - i];
            final int min = Math.min(L, R) + 1;
            final int max = Math.max(L, R) + limit;
            sweepLine[0] += 2;
            sweepLine[min]--;
            sweepLine[max + 1]++;
            sweepLine[L + R]--;
            sweepLine[L + R + 1]++;
        }
        for (int i = 0; i < size - 5; i++) {
            sweepLine[i + 1] += sweepLine[i];
        }
        int res = (int) 1e9;
        for (int i = 0; i < size - 5; i++) {
            res = Math.min(res, sweepLine[i]);
        }
        return res;
    }
}
