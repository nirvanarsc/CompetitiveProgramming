package leetcode.biweekly_contests.biweekly_80;

public class P_1 {

    public boolean strongPasswordCheckerII(String password) {
        final int n = password.length();
        if (n < 8) {
            return false;
        }
        final char[] w = password.toCharArray();
        for (int i = 0; i < n - 1; i++) {
            if (w[i] == w[i + 1]) {
                return false;
            }
        }
        int mask = 0;
        for (char c : w) {
            if (Character.isLowerCase(c)) {
                mask |= 1;
            } else if (Character.isUpperCase(c)) {
                mask |= 2;
            } else if (Character.isDigit(c)) {
                mask |= 4;
            } else if ("!@#$%^&*()-+".indexOf(c) >= 0) {
                mask |= 8;
            }
        }
        return mask == 15;
    }
}
