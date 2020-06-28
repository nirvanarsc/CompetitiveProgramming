package biweekly_contests.biweekly_29;

public class P_1493 {

    public int longestSubarray(int[] nums) {
        return longestOnes(nums, 1) - 1;
    }

    public int longestOnes(int[] nums, int k) {
        int j = 0;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                k--;
            }
            while (k < 0) {
                if (nums[j++] == 0) {
                    k++;
                }
            }
            res = Math.max(res, i - j + 1);
        }
        return res;
    }
}
