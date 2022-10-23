package leetcode.weekly_contests.weekly_0_99.weekly_42;

public class P_645 {

    public int[] findErrorNums(int[] nums) {
        final int n = nums.length;
        final boolean[] seen = new boolean[n];
        int sum = 0;
        int dup = -1;
        for (int num : nums) {
            if (seen[num - 1]) {
                dup = num;
            }
            seen[num - 1] = true;
            sum += num;
        }
        final int other = ((n * (n + 1)) / 2) - sum + dup;
        return new int[] { dup, other };
    }
}
