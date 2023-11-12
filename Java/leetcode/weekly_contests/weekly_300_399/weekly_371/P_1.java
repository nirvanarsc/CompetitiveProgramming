package leetcode.weekly_contests.weekly_300_399.weekly_371;

public class P_1 {

    public int maximumStrongPairXor(int[] nums) {
        int res = 0;
        for (int l : nums) {
            for (int r : nums) {
                if (Math.abs(l - r) <= Math.min(l, r)) {
                    res = Math.max(res, l ^ r);
                }
            }
        }
        return res;
    }
}
