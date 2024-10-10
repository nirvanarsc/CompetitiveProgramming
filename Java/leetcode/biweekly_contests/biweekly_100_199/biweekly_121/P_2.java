package leetcode.biweekly_contests.biweekly_100_199.biweekly_121;

public class P_2 {

    public int minOperations(int[] nums, int k) {
        int xor = k;
        for (int num : nums) {
            xor ^= num;
        }
        return Integer.bitCount(xor);
    }
}
