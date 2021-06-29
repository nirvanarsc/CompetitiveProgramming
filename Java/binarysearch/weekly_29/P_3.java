package binarysearch.weekly_29;

public class P_3 {

    public String solve(String s) {
        if (s.charAt(0) != '(' || s.charAt(s.length() - 1) != ')') {
            return s;
        }
        int open = 0;
        final int n = s.length();
        final char[] w = s.toCharArray();
        final int[] count = new int[n];
        final int[] op = new int[n];
        final int[] close = new int[n];
        for (int i = 0; i < n; i++) {
            final char c = w[i];
            if (c == '(') {
                op[open] = i;
                count[open++]++;
            } else if (c == ')') {
                open--;
                close[open] = i;
            }
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (count[i] != 1) {
                max = i;
                break;
            }
            if (i > 0 && ((1 + op[i - 1]) != op[i] || (1 + close[i] != close[i - 1]))) {
                max = i;
                break;
            }
        }
        return s.substring(max, n - max);
    }
}
