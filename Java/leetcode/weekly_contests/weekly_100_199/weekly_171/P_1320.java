package leetcode.weekly_contests.weekly_100_199.weekly_171;

public class P_1320 {

    public int minimumDistance(String word) {
        return minDist(word, 0, '*', '*', new Integer[27][27][word.length()]);
    }

    private static int minDist(String word, int pos, Character c1, Character c2, Integer[][][] dp) {
        if (pos == word.length()) {
            return 0;
        }
        final int idx1 = c1 == '*' ? 0 : c1 - 'A' + 1;
        final int idx2 = c2 == '*' ? 0 : c2 - 'A' + 1;
        if (dp[idx1][idx2][pos] != null) {
            return dp[idx1][idx2][pos];
        }
        return dp[idx1][idx2][pos] = Math.min(
                getDist(c1, word.charAt(pos)) + minDist(word, pos + 1, word.charAt(pos), c2, dp),
                getDist(c2, word.charAt(pos)) + minDist(word, pos + 1, c1, word.charAt(pos), dp));
    }

    private static int getDist(Character c1, Character c2) {
        if (c1 == '*' || c2 == '*') {
            return 0;
        }
        final int d1 = c1 - 'A';
        final int d2 = c2 - 'A';
        final int x1 = d1 / 6;
        final int y1 = d1 % 6;
        final int x2 = d2 / 6;
        final int y2 = d2 % 6;
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }
}
