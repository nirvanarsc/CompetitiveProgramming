package leetcode.weekly_contests.weekly_300_399.weekly_375;

public class P_3_2 {

    public long countSubarrays(int[] nums, int k) {
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        int curr = 0;
        int j = 0;
        long res = 0;
        for (int num : nums) {
            curr += num == max ? 1 : 0;
            while (curr == k) {
                curr -= nums[j++] == max ? 1 : 0;
            }
            res += j;
        }
        return res;
    }
}
