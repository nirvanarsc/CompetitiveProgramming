package easy;

public class P_38 {

    public String countAndSayOld(int n) {
        String s = "1";
        for (int i = 1; i < n; i++) {
            s = lookAndSay(s);
        }
        return s;
    }

    public String lookAndSay(String str) {
        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            int count = 1;
            while (i + 1 < str.length() && str.charAt(i) == str.charAt(i + 1)) {
                i++;
                count++;
            }
            sb.append(count);
            sb.append(str.charAt(i));
        }
        return sb.toString();
    }

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
