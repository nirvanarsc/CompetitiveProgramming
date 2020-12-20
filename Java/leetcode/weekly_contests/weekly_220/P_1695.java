package leetcode.weekly_contests.weekly_220;

public class P_1695 {

    public int maximumUniqueSubarray(int[] nums) {
        int j = 0;
        int curr = 0;
        int res = 0;
        final int[] map = new int[(int) (1e4 + 5)];
        boolean ok = true;
        for (int num : nums) {
            if (map[num]++ > 0) {
                ok = false;
            }
            curr += num;
            while (!ok) {
                if (--map[nums[j]] == 1) {
                    ok = true;
                }
                curr -= nums[j++];
            }
            res = Math.max(res, curr);
        }
        return res;
    }
}
