package leetcode.weekly_contests.weekly_300_399.weekly_392;

public class P_2 {

    public String getSmallestString(String s, int k) {
        final int n = s.length();
        final char[] w = s.toCharArray();
        for (int i = 0; i < n && k > 0; i++) {
            final int diff = Math.min(w[i] - 'a', ('a' - w[i] + 26) % 26);
            if (diff > k) {
                w[i] -= k;
                break;
            }
            k -= diff;
            w[i] = 'a';
        }
        return new String(w);
    }
}
