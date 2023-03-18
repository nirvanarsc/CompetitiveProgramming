package leetcode.biweekly_contests.biweekly_0_99.biweekly_39;

public class P_1653 {

    public int minimumDeletions(String s) {
        final int n = s.length();
        int a = 0, b = 0, res = (int) 1e9;
        for (int i = 0; i < n; i++) {
            a += s.charAt(i) == 'a' ? 1 : 0;
        }
        for (int i = 0; i <= n; i++) {
            res = Math.min(res, b + a);
            if (i < n && s.charAt(i) == 'b') {
                b++;
            } else {
                a--;
            }
        }
        return res;
    }
}
