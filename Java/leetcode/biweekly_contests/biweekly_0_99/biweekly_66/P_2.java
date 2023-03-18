package leetcode.biweekly_contests.biweekly_0_99.biweekly_66;

public class P_2 {

    public int minimumBuckets(String street) {
        final char[] w = street.toCharArray();
        final int n = w.length;
        int res = 0;
        for (int i = 1; i < (n - 1); i++) {
            if (w[i] == '.' && w[i - 1] == 'H' && w[i + 1] == 'H') {
                res++;
                w[i - 1] = '*';
                w[i + 1] = '*';
            }
        }
        for (int i = 0; i < n; i++) {
            if (w[i] == 'H') {
                if (i > 0 && w[i - 1] == '.') {
                    res++;
                } else if (i < (n - 1) && w[i + 1] == '.') {
                    res++;
                } else {
                    return -1;
                }
            }
        }
        return res;
    }
}
