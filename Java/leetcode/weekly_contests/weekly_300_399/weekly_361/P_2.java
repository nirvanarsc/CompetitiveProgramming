package leetcode.weekly_contests.weekly_300_399.weekly_361;

public class P_2 {

    public int minimumOperations(String num) {
        int res = (int) 1e9;
        for (String tar : new String[] { "00", "25", "50", "75" }) {
            res = Math.min(res, f(num, tar));
        }
        return res;
    }

    private static int f(String s, String tar) {
        final int n = s.length();
        final int notFoundRes = n - findZero(s);
        int u = n - 1;
        while (u >= 0 && s.charAt(u) != tar.charAt(1)) { u--; }
        if (u == -1) { return notFoundRes; }
        int v = u - 1;
        while (v >= 0 && s.charAt(v) != tar.charAt(0)) { v--; }
        if (v == -1) { return notFoundRes; }
        return n - v - 2;
    }

    private static int findZero(String s) {
        return s.indexOf('0') != -1 ? 1 : 0;
    }
}
