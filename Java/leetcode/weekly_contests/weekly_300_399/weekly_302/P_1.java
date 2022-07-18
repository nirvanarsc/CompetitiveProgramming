package leetcode.weekly_contests.weekly_300_399.weekly_302;

public class P_1 {

    public int[] numberOfPairs(int[] nums) {
        final int[] f = new int[101];
        for (int num : nums) {
            f[num]++;
        }
        int l = 0;
        int r = 0;
        for (int num : f) {
            l += num / 2;
            r += num % 2;
        }
        return new int[] { l, r };
    }
}
