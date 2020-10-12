package leetcode.weekly_contests.weekly_29;

public class P_564 {

    public String nearestPalindromic(String n) {
        final int half = n.length() / 2;
        final int order = (int) Math.pow(10, half);
        final long ans = Long.valueOf(n);
        final long noChange = mirror(ans);
        long larger = mirror((ans / order) * order + order);
        long smaller = mirror((ans / order) * order - 1);
        if (noChange > ans) {
            larger = Math.min(noChange, larger);
        } else if (noChange < ans) {
            smaller = Math.max(noChange, smaller);
        }
        return String.valueOf(ans - smaller <= larger - ans ? smaller : larger);
    }

    private static long mirror(long ans) {
        final char[] chars = String.valueOf(ans).toCharArray();
        int i = 0;
        int j = chars.length - 1;
        while (i < j) {
            chars[j--] = chars[i++];
        }
        return Long.valueOf(new String(chars));
    }
}
