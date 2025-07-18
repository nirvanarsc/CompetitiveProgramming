package leetcode.biweekly_contests.biweekly_100_199.biweekly_154;

public class P_2 {

    public int uniqueXorTriplets(int[] nums) {
        if (nums.length < 3) {
            return nums.length;
        }
        int res = 0;
        for (int num : nums) {
            res = Math.max(res, Integer.highestOneBit(num));
        }
        return res << 1;
    }
}
