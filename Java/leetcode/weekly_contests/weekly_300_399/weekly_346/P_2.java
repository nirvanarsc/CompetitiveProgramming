package leetcode.weekly_contests.weekly_300_399.weekly_346;

public class P_2 {

    public String makeSmallestPalindrome(String s) {
        final char[] w = s.toCharArray();
        int l = 0;
        int r = w.length - 1;
        while (l < r) {
            final char min = (char) Math.min(w[l], w[r]);
            w[l] = w[r] = min;
            l++;
            r--;
        }
        return new String(w);
    }
}
