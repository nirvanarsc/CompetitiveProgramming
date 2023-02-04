package leetcode.biweekly_contests.biweekly_97;

public class P_2 {

    public int maxCount(int[] banned, int n, int maxSum) {
        final boolean[] seen = new boolean[(int) (1e4 + 5)];
        for (int num : banned) {
            seen[num] = true;
        }
        int res = 0;
        for (int num = 1; num <= n; num++) {
            if (!seen[num]) {
                if (maxSum >= num) {
                    maxSum -= num;
                    res++;
                }
            }
        }
        return res;
    }
}
