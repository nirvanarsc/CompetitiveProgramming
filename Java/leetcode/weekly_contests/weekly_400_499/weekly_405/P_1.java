package leetcode.weekly_contests.weekly_400_499.weekly_405;

public class P_1 {

    public String getEncryptedString(String s, int k) {
        final char[] w = s.toCharArray();
        final int n = w.length;
        final char[] res = new char[n];
        for (int i = k % n, j = 0; j < n; j++, i = (i + 1) % n) {
            res[j] = w[i];
        }
        return new String(res);
    }
}
