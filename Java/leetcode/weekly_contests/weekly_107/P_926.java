package leetcode.weekly_contests.weekly_107;

@SuppressWarnings("MethodParameterNamingConvention")
public class P_926 {

    public int minFlipsMonoIncrOptimized(String S) {
        int zeroes = 0, ones = 0;
        for (char c : S.toCharArray()) {
            if (c == '1') {
                ++ones;
            } else {
                ++zeroes;
            }
            zeroes = Math.min(ones, zeroes);
        }
        return zeroes;
    }

    public int minFlipsMonoIncr(String S) {
        final int n = S.length();
        final int[] prefixOne = new int[n + 1];
        final int[] prefixZero = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            prefixOne[i] = prefixOne[i - 1] + (S.charAt(i - 1) == '1' ? 1 : 0);
            prefixZero[i] = prefixZero[i - 1] + (S.charAt(i - 1) == '0' ? 1 : 0);
        }
        int res = prefixZero[n];
        for (int i = 1; i <= n; i++) {
            final int lOne = prefixOne[i];
            final int rZero = prefixZero[n] - prefixZero[i];
            res = Math.min(res, lOne + rZero);
        }
        return res;
    }
}
