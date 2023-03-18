package leetcode.biweekly_contests.biweekly_0_99.biweekly_18;

public class P_1328 {

    public String breakPalindrome(String palindrome) {
        final char[] w = palindrome.toCharArray();
        final int n = palindrome.length();
        for (int i = 0; i < n / 2; i++) {
            if (w[i] != 'a') {
                w[i] = 'a';
                return new String(w);
            }
        }
        w[n - 1] = 'b';
        return n == 1 ? "" : new String(w);
    }
}
