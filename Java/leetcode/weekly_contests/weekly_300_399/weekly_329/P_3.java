package leetcode.weekly_contests.weekly_300_399.weekly_329;

public class P_3 {

    public boolean makeStringsEqual(String s, String target) {
        if (s.equals(target)) {
            return true;
        }
        final char[] l = s.toCharArray();
        final char[] r = target.toCharArray();
        final int n = s.length();
        final int[] ll = new int[2];
        final int[] rr = new int[2];
        for (int i = 0; i < n; i++) {
            ll[l[i] - '0']++;
            rr[r[i] - '0']++;
        }
        return ((ll[0] > 0 && ll[1] > 0) || ll[1] == n) && (rr[0] > 0 && rr[1] > 0 || rr[1] == n);
    }
}
