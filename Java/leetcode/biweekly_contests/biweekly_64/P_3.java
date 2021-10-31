package leetcode.biweekly_contests.biweekly_64;

import java.util.TreeSet;

@SuppressWarnings("ConstantConditions")
public class P_3 {

    public int[] platesBetweenCandles(String s, int[][] queries) {
        final TreeSet<Integer> ts = new TreeSet<>();
        final int n = s.length();
        final int q = queries.length;
        final char[] w = s.toCharArray();
        ts.add(-1);
        ts.add(n);
        final int[] pre = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int curr = 0;
            if (w[i - 1] == '|') {
                ts.add(i - 1);
            } else {
                curr = 1;
            }
            pre[i] = pre[i - 1] + curr;
        }
        final int[] res = new int[q];
        for (int i = 0; i < q; i++) {
            final int[] qq = queries[i];
            final int l = qq[0];
            final int r = qq[1];
            final int ll = ts.lower(r);
            final int rr = ts.higher(l);
            int curr = pre[r + 1] - pre[l];
            if (w[l] == '*') {
                curr -= rr - l;
            }
            if (w[r] == '*') {
                curr -= r - ll;
            }
            if (w[l] == '*' && w[r] == '*' && rr > ll) {
                curr = 0;
            }
            res[i] = curr;
        }
        return res;
    }
}
