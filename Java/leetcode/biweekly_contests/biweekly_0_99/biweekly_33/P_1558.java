package leetcode.biweekly_contests.biweekly_0_99.biweekly_33;

public class P_1558 {

    public int minOperations(int[] nums) {
        int res = 0, max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
            res += Integer.bitCount(num);
        }
        while (max > 1) {
            ++res;
            max >>= 1;
        }
        return res;
    }
}
