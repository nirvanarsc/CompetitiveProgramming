package leetcode.weekly_contests.weekly_293;

public class P_3 {

    public int largestCombination(int[] candidates) {
        final int[] f = new int[30];
        for (int num : candidates) {
            for (int i = 0; i < 30; i++) {
                if ((num & (1 << i)) != 0) {
                    f[i]++;
                }
            }
        }
        int max = 0;
        for (int i = 0; i < 30; i++) {
            max = Math.max(max, f[i]);
        }
        return max;
    }
}
