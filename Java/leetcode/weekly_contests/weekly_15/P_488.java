package leetcode.weekly_contests.weekly_15;

public class P_488 {

    public int findMinStep(String board, String hand) {
        final int[] h = new int[128];
        for (char c : hand.toCharArray()) {
            h[c]++;
        }
        final int res = helper(board, h);
        return res == (int) 1e9 ? -1 : res;
    }

    private static int helper(String s, int[] h) {
        if (s.isEmpty()) {
            return 0;
        }
        int idx = 0, res = (int) 1e9;
        while (idx < s.length()) {
            int j = idx;
            while (j < s.length() && s.charAt(j) == s.charAt(idx)) {
                j++;
            }
            final int need = Math.max(0, 3 - j + idx);
            if (h[s.charAt(idx)] >= need) {
                h[s.charAt(idx)] -= need;
                res = Math.min(res, need + helper(s.substring(0, idx) + s.substring(j), h));
                h[s.charAt(idx)] += need;
            }
            idx = j;
        }
        return res;
    }
}
