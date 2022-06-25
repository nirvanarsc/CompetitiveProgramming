package leetcode.biweekly_contests.biweekly_81;

public class P_3 {

    public int maximumXOR(int[] nums) {
        int res = 0;
        for (int num : nums) {
            for (int i = 0; i < 30; i++) {
                if ((num & (1 << i)) != 0) {
                    res |= 1 << i;
                }
            }
        }
        return res;
    }
}
