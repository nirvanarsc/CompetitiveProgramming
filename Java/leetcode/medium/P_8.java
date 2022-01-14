package leetcode.medium;

public class P_8 {

    public int myAtoi(String str) {
        final int n = str.length();
        final char[] w = str.toCharArray();
        int i = 0;
        while (i < n && w[i] == ' ') {
            i++;
        }
        if (i == n || (w[i] != '-' && w[i] != '+' && !Character.isDigit(w[i]))) {
            return 0;
        }
        boolean sign = true;
        if (w[i] == '-' || w[i] == '+') {
            sign = w[i] == '+';
            i++;
        }
        int res = 0;
        while (i < n && Character.isDigit(w[i])) {
            final int curr = Character.getNumericValue(w[i]);
            if (res > Integer.MAX_VALUE / 10 || res == Integer.MAX_VALUE / 10 && curr > 7) {
                return sign ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            res = res * 10 + curr;
            i++;
        }
        return sign ? res : -res;
    }
}
