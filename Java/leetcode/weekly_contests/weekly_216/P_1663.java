package leetcode.weekly_contests.weekly_216;

public class P_1663 {

    public String getSmallestString(int n, int k) {
        final int[] str = new int[n];
        k -= n;
        int idx = n - 1;
        while (k > 0) {
            final int take = Math.min(25, k);
            k -= take;
            str[idx--] += take;
        }
        final char[] res = new char[n];
        for (int i = 0; i < n; i++) {
            res[i] = (char) (str[i] + 'a');
        }
        return new String(res);
    }
}
