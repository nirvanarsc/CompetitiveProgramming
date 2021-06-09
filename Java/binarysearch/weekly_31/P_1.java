package binarysearch.weekly_31;

public class P_1 {

    public int solve(String s) {
        int res = s.isEmpty() ? 0 : 1;
        final StringBuilder compressed = new StringBuilder();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if (compressed.length() > 0 && s.charAt(i) == compressed.charAt(compressed.length() - 1)) {
                continue;
            }
            compressed.append(s.charAt(i));
        }
        final char[] w = compressed.toString().toCharArray();
        n = w.length;
        final boolean[] prev = new boolean[n];
        for (int i = 1; i < n - 1; i++) {
            if (w[i - 1] < w[i] && w[i] > w[i + 1] && !prev[i - 1]) {
                res++;
                prev[i] = true;
            }
            if (w[i - 1] > w[i] && w[i] < w[i + 1] && !prev[i - 1]) {
                res++;
                prev[i] = true;
            }
        }
        return res;
    }
}
