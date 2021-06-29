package binarysearch.weekly_29;

public class P_1 {

    public int solve(String s) {
        int res = 0;
        final int n = s.length();
        final char[] w = s.toCharArray();
        for (int i = 0; i < n; i++) {
            int j = i;
            while (j < n && w[j] == w[i]) {
                j++;
            }
            res += (j - i) / 3;
            i = j - 1;
        }
        return res;
    }
}
