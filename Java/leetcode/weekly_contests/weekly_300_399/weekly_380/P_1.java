package leetcode.weekly_contests.weekly_300_399.weekly_380;

public class P_1 {

    public int maxFrequencyElements(int[] nums) {
        final int[] f = new int[105];
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, ++f[num]);
        }
        int res = 0;
        for (int i = 0; i < 105; i++) {
            res += f[i] == max ? max : 0;
        }
        return res;
    }
}
