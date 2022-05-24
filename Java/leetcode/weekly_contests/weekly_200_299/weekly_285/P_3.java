package leetcode.weekly_contests.weekly_200_299.weekly_285;

public class P_3 {

    public int[] maximumBobPoints(int numArrows, int[] aliceArrows) {
        final int n = aliceArrows.length;
        int max = -1;
        int bestMask = -1;
        for (int mask = 0; mask < (1 << n); mask++) {
            int need = 0;
            int score = 0;
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    need += aliceArrows[i] + 1;
                    score += i;
                }
            }
            if (need > numArrows) {
                continue;
            }
            if (score > max) {
                max = score;
                bestMask = mask;
            }
        }
        final int[] res = new int[12];
        for (int i = 0; i < n; i++) {
            if ((bestMask & (1 << i)) != 0) {
                res[i] = aliceArrows[i] + 1;
                numArrows -= res[i];
            }
        }
        res[0] += numArrows;
        return res;
    }
}
