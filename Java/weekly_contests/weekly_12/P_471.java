package weekly_contests.weekly_12;

public class P_471 {

    public String encode(String s) {
        final int n = s.length();
        final String[][] dp = new String[n][n];
        for (int l = 0; l < n; l++) {
            for (int i = 0; i < n - l; i++) {
                final int j = i + l;
                final String sub = s.substring(i, j + 1);
                dp[i][j] = sub;
                if (l >= 4) {
                    for (int k = i; k < j; k++) {
                        if (dp[i][k].length() + dp[k + 1][j].length() < dp[i][j].length()) {
                            dp[i][j] = dp[i][k] + dp[k + 1][j];
                        }
                    }
                    final String pattern = kmp(sub);
                    if (pattern.length() != sub.length()) {
                        final String encode = sub.length() / pattern.length() +
                                              "[" + dp[i][i + pattern.length() - 1] + ']';
                        if (encode.length() < dp[i][j].length()) {
                            dp[i][j] = encode;
                        }
                    }
                }
            }
        }
        return dp[0][n - 1];
    }

    private static String kmp(String str) {
        final int n = str.length();
        final int[] prefixSuffix = new int[n];
        for (int i = 1, j = 0; i < n; i++) {
            while (j > 0 && str.charAt(i) != str.charAt(j)) {
                j = prefixSuffix[j - 1];
            }
            if (str.charAt(i) == str.charAt(j)) {
                j++;
            }
            prefixSuffix[i] = j;
        }
        final int newLength = n - prefixSuffix[n - 1];
        return n % newLength == 0 ? str.substring(0, newLength) : str;
    }
}
