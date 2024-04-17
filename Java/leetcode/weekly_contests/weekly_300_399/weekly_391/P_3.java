package leetcode.weekly_contests.weekly_300_399.weekly_391;

public class P_3 {

    public long countAlternatingSubarrays(int[] nums) {
        final int n = nums.length;
        long res = 0;
        for (int i = 0; i < n; i++) {
            int j = i + 1;
            while (j < n && (nums[j - 1] ^ nums[j]) == 1) {
                j++;
            }
            final long l = j - i;
            res += (l * (l + 1)) / 2;
            i = j - 1;
        }
        return res;
    }
}
