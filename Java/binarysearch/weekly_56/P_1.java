package binarysearch.weekly_56;

public class P_1 {

    public boolean solve(String s) {
        final int[] f = new int[10];
        for (char c : s.toCharArray()) {
            f[c - '0']++;
        }
        for (int i = 0; i < 10; i++) {
            f[i] %= 3;
        }
        int zero = 0;
        int two = 0;
        for (int i = 0; i < 10; i++) {
            if (f[i] == 2) {
                two++;
            } else if (f[i] == 0) {
                zero++;
            }
        }
        return zero == 9 && two == 1;
    }
}
