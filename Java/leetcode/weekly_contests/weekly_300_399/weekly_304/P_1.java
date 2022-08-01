package leetcode.weekly_contests.weekly_300_399.weekly_304;

public class P_1 {

    public int minimumOperations(int[] nums) {
        final boolean[] seen = new boolean[105];
        for (int num : nums) {
            seen[num] = true;
        }
        int res = 0;
        for (int i = 1; i < seen.length; i++) {
            if (seen[i]) {
                res++;
            }
        }
        return res;
    }
}
