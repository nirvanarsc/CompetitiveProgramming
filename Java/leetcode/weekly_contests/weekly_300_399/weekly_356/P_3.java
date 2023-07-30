package leetcode.weekly_contests.weekly_300_399.weekly_356;

public class P_3 {

    public String minimumString(String a, String b, String c) {
        final String[] w = { a, b, c };
        final int[][] order = { { 0, 1, 2 }, { 0, 2, 1 }, { 1, 0, 2 }, { 1, 2, 0 }, { 2, 1, 0 }, { 2, 0, 1 } };
        String res = null;
        for (int[] ord : order) {
            String curr = "";
            for (int idx : ord) {
                curr = f(curr, w[idx]);

            }
            if (res != null) {
                if (res.length() > curr.length()) {
                    res = curr;
                } else if (res.length() == curr.length() && res.compareTo(curr) > 0) {
                    res = curr;
                }
            } else {
                res = curr;
            }
        }
        return res;
    }

    private static String f(String curr, String w) {
        if (curr.contains(w)) {
            return curr;
        }
        for (int len = Math.min(curr.length(), w.length()); len > 0; len--) {
            if (curr.substring(curr.length() - len).equals(w.substring(0, len))) {
                return curr + w.substring(len);
            }
        }
        return curr + w;
    }
}
