package leetcode.biweekly_contests.biweekly_0_99.biweekly_85;

public class P_1 {

    public int minimumRecolors(String blocks, int k) {
        final char[] w = blocks.toCharArray();
        final int n = w.length;
        int curr = 0;
        int best = 0;
        for (int i = 0; i < n; i++) {
            curr += w[i] == 'B' ? 1 : 0;
            if (i >= k) {
                curr -= w[i - k] == 'B' ? 1 : 0;
            }
            best = Math.max(best, curr);
        }
        return k - best;
    }
}
