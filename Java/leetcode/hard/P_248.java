package leetcode.hard;

public class P_248 {

    private static final char[][] PAIRS =
            { { '0', '0' }, { '1', '1' }, { '6', '9' }, { '8', '8' }, { '9', '6' } };

    public int strobogrammaticInRange(String low, String high) {
        final int[] res = { 0 };
        for (int len = low.length(); len <= high.length(); len++) {
            dfs(low, high, new char[len], 0, len - 1, res);
        }
        return res[0];
    }

    public void dfs(String low, String high, char[] c, int left, int right, int[] res) {
        if (left > right) {
            if (c.length == 1 || c[0] != '0') {
                final String num = String.valueOf(c);
                if (num.length() == low.length() && num.compareTo(low) < 0
                    || num.length() == high.length() && num.compareTo(high) > 0) {
                    return;
                }
                res[0]++;
            }
            return;
        }
        for (char[] p : PAIRS) {
            if (left == right && p[0] != p[1]) { continue; }
            c[left] = p[0];
            c[right] = p[1];
            dfs(low, high, c, left + 1, right - 1, res);
        }
    }
}
