package leetcode.weekly_contests.weekly_200_299.weekly_296;

public class P_1 {

    public int minMaxGame(int[] nums) {
        int n = nums.length;
        int[] prev = nums;
        while ((n / 2) > 0) {
            final int[] next = new int[n / 2];
            for (int j = 0; j < (n / 2); j++) {
                if (j % 2 == 0) {
                    next[j] = Math.min(prev[2 * j], prev[2 * j + 1]);
                } else {
                    next[j] = Math.max(prev[2 * j], prev[2 * j + 1]);
                }
            }
            prev = next;
            n /= 2;
        }
        return prev[0];
    }
}
