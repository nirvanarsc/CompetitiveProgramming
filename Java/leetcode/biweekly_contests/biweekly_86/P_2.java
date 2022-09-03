package leetcode.biweekly_contests.biweekly_86;

public class P_2 {

    public boolean isStrictlyPalindromic(int n) {
        for (int b = 2; b < n - 1; b++) {
            if (!isPalindrome(Integer.toString(n, b))) {
                return false;
            }
        }
        return true;
    }

    private static boolean isPalindrome(String s) {
        final char[] w = s.toCharArray();
        int l = 0;
        int r = w.length - 1;
        while (l < r) {
            if (w[l++] != w[r--]) {
                return false;
            }
        }
        return true;
    }
}
