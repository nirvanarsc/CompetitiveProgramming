package leetcode.weekly_contests.weekly_108;

public class P_932 {

    public int[] beautifulArray(int n) {
        int[] res = new int[n];
        res[0] = 1;
        int len = 1;
        while (len < n) {
            final int[] next = new int[n];
            int idx = 0;
            for (int i = 0; i < len; i++) {
                final int add = res[i] * 2 - 1;
                if (add <= n) {
                    next[idx++] = add;
                }
            }
            for (int i = 0; i < len; i++) {
                final int add = res[i] * 2;
                if (add <= n) {
                    next[idx++] = add;
                }
            }
            res = next;
            len = idx;
        }
        return res;
    }
}
