package leetcode.biweekly_contests.biweekly_0_99.biweekly_68;

public class P_3 {

    public boolean canBeValid(String s, String locked) {
        final char[] w = s.toCharArray();
        final int n = s.length();
        for (int i = 0; i < n; i++) {
            if (locked.charAt(i) == '0') {
                w[i] = '*';
            }
        }
        return n % 2 == 0 && checkValidString(w);
    }

    public boolean checkValidString(char[] s) {
        int minOpen = 0;
        int maxOpen = 0;
        for (char c : s) {
            if (c == '(') {
                minOpen++;
                maxOpen++;
            } else if (c == '*') {
                minOpen--;
                maxOpen++;
            } else {
                if (maxOpen == 0) {
                    return false;
                }
                minOpen--;
                maxOpen--;
            }
            minOpen = Math.max(minOpen, 0);
        }
        return minOpen == 0;
    }
}
