package leetcode.easy;

public class P_38 {

    static final String[] dp = new String[30];

    public String countAndSay(int n) {
        if (dp[n - 1] != null) {
            return dp[n - 1];
        }
        dp[0] = "1";
        for (int i = 1; i < dp.length; i++) {
            final StringBuilder sb = new StringBuilder();
            final String prev = dp[i - 1];
            int j = 0;
            while (j < prev.length()) {
                final int start = j;
                final char currNum = prev.charAt(j);
                while (j < prev.length() && currNum == prev.charAt(j)) {
                    j++;
                }
                sb.append(j - start);
                sb.append(currNum);
            }
            dp[i] = sb.toString();
        }
        return dp[n - 1];
    }
}
