package leetcode.weekly_contests.weekly_300_399.weekly_307;

public class P_2 {

    public String largestPalindromic(String num) {
        final int[] f = new int[10];
        for (char c : num.toCharArray()) {
            f[c - '0']++;
        }
        final StringBuilder l = new StringBuilder();
        final StringBuilder r = new StringBuilder();
        for (int i = 9; i >= 0; i--) {
            if (i == 0 && l.length() == 0) {
                break;
            }
            while (f[i] > 1) {
                l.append(i);
                r.append(i);
                f[i] -= 2;
            }
        }
        for (int i = 9; i >= 0; i--) {
            if (f[i] > 0) {
                l.append(i);
                break;
            }
        }
        final String ll = l.toString();
        final String rr = r.reverse().toString();
        return ll + rr;
    }
}
