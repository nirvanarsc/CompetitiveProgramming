package leetcode.weekly_contests.weekly_200_299.weekly_268;

public class P_1 {

    public int maxDistance(int[] colors) {
        int res = 0;
        final int n = colors.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (colors[i] != colors[j]) {
                    res = Math.max(res, j - i);
                }
            }
        }
        return res;
    }
}
