package leetcode.weekly_contests.weekly_100_199.weekly_144;

public class P_1111 {

    public int[] maxDepthAfterSplit(String seq) {
        int depth = 0;
        int cur = 0;
        final int n = seq.length();
        for (int i = 0; i < n; ++i) {
            cur +=  seq.charAt(i) == '(' ?  1 : -1;
            depth = Math.max(depth, cur);
        }
        final int[] res = new int[n];
        for (int i = 0; i < n; ++i) {
            if (seq.charAt(i) == '(') {
                if (++cur > depth / 2) {
                    res[i] = 1;
                }
            } else {
                if (cur-- > depth / 2) {
                    res[i] = 1;
                }
            }
        }
        return res;
    }
}
