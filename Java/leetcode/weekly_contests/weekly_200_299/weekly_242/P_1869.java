package leetcode.weekly_contests.weekly_200_299.weekly_242;

public class P_1869 {

    public boolean checkZeroOnes(String s) {
        final char[] w = s.toCharArray();
        final int n = w.length;
        return f(w, '1', n) > f(w, '0', n);
    }

    private static int f(char[] w, char c, int n) {
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (w[i] == c) {
                int j = i;
                while (j < n && w[i] == w[j]) {
                    j++;
                }
                res = Math.max(res, j - i);
                i = j - 1;
            }
        }
        return res;
    }
}
