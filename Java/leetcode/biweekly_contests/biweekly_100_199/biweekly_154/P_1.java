package leetcode.biweekly_contests.biweekly_100_199.biweekly_154;

public class P_1 {

    public int minOperations(int[] nums, int k) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return sum % k;
    }
}
