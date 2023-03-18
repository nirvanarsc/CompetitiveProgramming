package leetcode.biweekly_contests.biweekly_0_99.biweekly_95;

public class P_3 {

    public int xorBeauty(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res ^= num;
        }
        return res;
    }
}
