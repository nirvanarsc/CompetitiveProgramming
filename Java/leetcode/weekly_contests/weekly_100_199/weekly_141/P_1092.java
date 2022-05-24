package leetcode.weekly_contests.weekly_100_199.weekly_141;

import java.util.Arrays;

public class P_1092 {

    public String shortestCommonSupersequence(String str1, String str2) {
        final String lcs = longestCommonSubSeq(str1, str2);
        int p1 = 0, p2 = 0;
        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < lcs.length(); i++, p1++, p2++) {
            while (p1 < str1.length() && str1.charAt(p1) != lcs.charAt(i)) {
                sb.append(str1.charAt(p1++));
            }
            while (p2 < str2.length() && str2.charAt(p2) != lcs.charAt(i)) {
                sb.append(str2.charAt(p2++));
            }
            sb.append(lcs.charAt(i));
        }

        return sb.append(str1.substring(p1)).append(str2.substring(p2)).toString();
    }

    private static String longestCommonSubSeq(String str1, String str2) {
        final String[][] dp = new String[str1.length() + 1][str2.length() + 1];
        for (String[] strings : dp) {
            Arrays.fill(strings, "");
        }
        for (int i = 1; i <= str1.length(); i++) {
            for (int j = 1; j <= str2.length(); j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + str1.charAt(i - 1);
                } else {
                    dp[i][j] = dp[i - 1][j].length() > dp[i][j - 1].length() ? dp[i - 1][j] : dp[i][j - 1];
                }
            }
        }
        return dp[str1.length()][str2.length()];
    }
}
