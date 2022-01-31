package leetcode.weekly_contests.weekly_217;

public class P_1674 {

    public int minMoves(int[] nums, int limit) {
        final int n = nums.length;
        final int size = 2 * limit + 2;
        final int[] delta = new int[size];
        for (int i = 0; i < n / 2; i++) {
            final int L = nums[i];
            final int R = nums[n - 1 - i];
            final int min = Math.min(L, R) + 1;
            final int max = Math.max(L, R) + limit + 1;
            delta[2] += 2;
            delta[min]--;
            delta[max]++;
            delta[L + R]--;
            delta[L + R + 1]++;
        }
        int res = 2 * n;
        int curr = 0;
        for (int i = 2; i <= 2 * limit; i++) {
            curr += delta[i];
            res = Math.min(res, curr);
        }
        return res;
    }
}
