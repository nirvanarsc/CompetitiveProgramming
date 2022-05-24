package leetcode.weekly_contests.weekly_100_199.weekly_149;

public class P_1156 {

    public int maxRepOpt1(String text) {
        final int n = text.length();
        int res = 0;
        for (char c = 'a'; c <= 'z'; c++) {
            int count = 0;
            for (int i = 0; i < n; i++) {
                if (text.charAt(i) == c) {
                    count++;
                }
            }
            if (count == n) {
                return n;
            }
            for (int i = 0; i < n; i++) {
                if (text.charAt(i) != c) {
                    int left = i, right = i;
                    while (left > 0 && text.charAt(left - 1) == c) { left--; }
                    while (right < n - 1 && text.charAt(right + 1) == c) { right++; }
                    final int combined = right - left;
                    if (combined == count) {
                        res = Math.max(res, count);
                    } else {
                        res = Math.max(res, combined + 1);
                    }
                }
            }
        }
        return res;
    }
}
