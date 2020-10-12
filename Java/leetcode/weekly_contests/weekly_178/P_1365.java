package leetcode.weekly_contests.weekly_178;

public class P_1365 {

    public int[] smallerNumbersThanCurrent(int[] nums) {
        final int[] res = new int[nums.length];
        final int[] map = new int[101];
        for (int i : nums) {
            map[i]++;
        }
        for (int i = 1; i < map.length; i++) {
            map[i] += map[i - 1];
        }
        for (int i = 0; i < nums.length; i++) {
            res[i] = nums[i] > 0 ? map[nums[i] - 1] : 0;
        }
        return res;
    }
}
