package leetcode.biweekly_contests.biweekly_100_199.biweekly_140;

public class P_1 {

    public int minElement(int[] nums) {
        int res = (int) 1e9;
        for (int num : nums) {
            int curr = 0;
            while (num > 0) {
                curr += num % 10;
                num /= 10;
            }
            res = Math.min(res, curr);
        }
        return res;
    }
}
