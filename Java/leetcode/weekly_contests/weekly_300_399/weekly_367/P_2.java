package leetcode.weekly_contests.weekly_300_399.weekly_367;

public class P_2 {

    public String shortestBeautifulSubstring(String s, int k) {
        final int n = s.length();
        final char[] w = s.toCharArray();
        final int[] pre = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            pre[i] = pre[i - 1] + w[i - 1] - '0';
        }
        String res = null;
        for (int i = k; i <= n; i++) {
            for (int j = 0; j <= n - i; j++) {
                if (pre[j + i] - pre[j] == k) {
                    final String curr = s.substring(j, j + i);
                    if (res == null || res.compareTo(curr) > 0) {
                        res = curr;
                    }
                }
            }
            if (res != null) {
                return res;
            }
        }
        return "";
    }
}
