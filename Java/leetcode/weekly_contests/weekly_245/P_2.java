package leetcode.weekly_contests.weekly_245;

public class P_2 {

    public int maximumRemovals(String s, String p, int[] removable) {
        int lo = 0;
        int hi = removable.length;
        while (lo < hi) {
            final int mid = lo + hi + 1 >>> 1;
            if (!f(s, p, removable, mid)) {
                hi = mid - 1;
            } else {
                lo = mid;
            }
        }
        return lo;
    }

    private static boolean f(String s, String p, int[] removable, int idx) {
        final boolean[] marked = new boolean[s.length()];
        for (int i = 0; i < idx; i++) {
            marked[removable[i]] = true;
        }
        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (!marked[i]) {
                sb.append(s.charAt(i));
            }
        }
        return isSubsequence(p, sb.toString());
    }

    public static boolean isSubsequence(String s, String t) {
        int i = 0;
        for (int j = 0; j < t.length(); j++) {
            if (i < s.length() && t.charAt(j) == s.charAt(i)) {
                i++;
            }
        }
        return i == s.length();
    }
}
