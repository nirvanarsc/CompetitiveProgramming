package leetcode.weekly_contests.weekly_42;

public class P_645 {

    public int[] findErrorNums(int[] nums) {
        final boolean[] seen = new boolean[(int) (1e4 + 5)];
        int sum = 0;
        int dup = -1;
        for (int num : nums) {
            if (seen[num]) {
                dup = num;
            }
            seen[num] = true;
            sum += num;
        }
        final int other = ((nums.length * (nums.length + 1)) / 2) - sum + dup;
        return new int[] { dup, other };
    }
}
