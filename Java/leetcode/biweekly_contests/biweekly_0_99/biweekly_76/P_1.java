package leetcode.biweekly_contests.biweekly_0_99.biweekly_76;

public class P_1 {

    public int findClosestNumber(int[] nums) {
        int curr = (int) 1e9;
        int res = -1;
        for (int num : nums) {
            final int abs = Math.abs(num);
            if (abs < curr) {
                curr = abs;
                res = num;
            } else if (abs == curr && num > 0) {
                res = num;
            }
        }
        return res;
    }
}
