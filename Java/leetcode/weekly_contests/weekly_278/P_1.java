package leetcode.weekly_contests.weekly_278;

public class P_1 {

    public int findFinalValue(int[] nums, int original) {
        final boolean[] ok = new boolean[1005];
        for (int num : nums) {
            ok[num] = true;
        }
        while (original < ok.length && ok[original]) {
            original <<= 1;
        }
        return original;
    }
}
