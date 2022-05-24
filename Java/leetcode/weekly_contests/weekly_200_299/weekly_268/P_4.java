package leetcode.weekly_contests.weekly_200_299.weekly_268;

public class P_4 {

    public long kMirror(int k, int n) {
        long res = 0;
        for (int len = 1; true; len++) {
            final int x = (int) Math.pow(10, (len - 1) / 2);
            final int y = (int) Math.pow(10, (len + 1) / 2);

            for (int i = x; i < y; i++) {
                long b = i;
                for (int j = len % 2 != 0 ? i / 10 : i; j > 0; j /= 10) {
                    b = b * 10 + j % 10;
                }
                final String h = Long.toString(b, k);
                if (isPalindrome(h.toCharArray())) {
                    res += b;
                    if (--n == 0) {
                        return res;
                    }
                }
            }
        }
    }

    public boolean isPalindrome(char[] w) {
        int l = 0;
        int r = w.length - 1;
        while (l < r) {
            if (w[l++] != w[r--]) {
                return false;
            }
        }
        return true;
    }
}
