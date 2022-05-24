package leetcode.weekly_contests.weekly_0_99.smarking_3;

public class P_453 {

    public int minMoves(int[] nums) {
        int min = Integer.MAX_VALUE, res = 0;
        for (int num : nums) {
            min = Math.min(min, num);
        }
        for (int num : nums) {
            res += num - min;
        }
        return res;
    }
}
