package leetcode.weekly_contests.weekly_200_299.weekly_286;

public class P_3 {

    public long[] kthPalindrome(int[] queries, int intLength) {
        int base = 1;
        for (int i = 0; i < (intLength - 1) / 2; i++) {
            base *= 10;
        }
        final int q = queries.length;
        final long[] res = new long[q];
        final boolean odd = intLength % 2 != 0;
        for (int i = 0; i < q; i++) {
            int l = base + queries[i] - 1;
            if (odd) {
                final int mid = l % 10;
                l /= 10;
                String ll = String.valueOf(l);
                if (l == 0) {
                    ll = "";
                }
                if (ll.length() * 2 + 1 != intLength) {
                    res[i] = -1;
                    continue;
                }
                final String curr = ll + mid + new StringBuilder(ll).reverse();
                res[i] = Long.valueOf(curr);
            } else {
                final String ll = String.valueOf(l);
                if (ll.length() * 2 != intLength) {
                    res[i] = -1;
                    continue;
                }
                final String curr = ll + new StringBuilder(ll).reverse();
                res[i] = Long.valueOf(curr);
            }
        }
        return res;
    }
}
