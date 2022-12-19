package leetcode.biweekly_contests.biweekly_93;

public class P_3 {

    public int maxJump(int[] stones) {
        final int n = stones.length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (i < n - 2) {
                res = Math.max(res, stones[i + 2] - stones[i]);
            }
            if (i < n - 1) {
                res = Math.max(res, stones[i + 1] - stones[i]);
            }
        }
        return res;
    }
}
