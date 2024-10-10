package leetcode.biweekly_contests.biweekly_100_199.biweekly_121;

public class P_1 {

    public int missingInteger(int[] nums) {
        int s = nums[0];
        int i = 0;
        final int n = nums.length;
        while ((i + 1) < n && nums[i + 1] - nums[i] == 1) {
            s += nums[i + 1];
            i++;
        }
        final boolean[] seen = new boolean[55];
        for (int num : nums) {
            seen[num] = true;
        }
        while (s < seen.length && seen[s]) {
            s++;
        }
        return s;
    }
}
