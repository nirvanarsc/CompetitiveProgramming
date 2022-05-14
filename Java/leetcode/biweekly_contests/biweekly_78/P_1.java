package leetcode.biweekly_contests.biweekly_78;

public class P_1 {

    public int divisorSubstrings(int num, int k) {
        final String s = String.valueOf(num);
        final int n = s.length();
        int res = 0;
        for (int i = 0; i <= n - k; i++) {
            final int v = Integer.parseInt(s.substring(i, i + k));
            if (v > 0 && num % v == 0) {
                res++;
            }
        }
        return res;
    }
}
