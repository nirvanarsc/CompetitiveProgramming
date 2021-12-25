package leetcode.medium;

public class P_227 {

    public int calculate(String s) {
        final int n = s.length();
        int res = 0;
        int curr = 0;
        int prev = 0;
        char operation = '+';
        for (int i = 0; i < n; i++) {
            final char c = s.charAt(i);
            if (Character.isDigit(c)) {
                curr = (curr * 10) + (c - '0');
            }
            if (!Character.isDigit(c) && !Character.isWhitespace(c) || i == n - 1) {
                if (operation == '+' || operation == '-') {
                    res += prev;
                    prev = (operation == '+') ? curr : -curr;
                } else if (operation == '*') {
                    prev *= curr;
                } else if (operation == '/') {
                    prev /= curr;
                }
                operation = c;
                curr = 0;
            }
        }
        return res + prev;
    }
}
