package leetcode.weekly_contests.weekly_300_399.weekly_305;

public class P_1 {

    public int arithmeticTriplets(int[] nums, int diff) {
        final boolean[] seen = new boolean[1005];
        int res = 0;
        for (int num : nums) {
            seen[num] = true;
        }
        for (int num : nums) {
            if (seen[num + diff] && seen[num + 2 * diff]) {
                res++;
            }
        }
        return res;
    }
}
