package leetcode.biweekly_contests.biweekly_18;

public class P_1328 {

    public String breakPalindrome(String palindrome) {
        final char[] chars = palindrome.toCharArray();
        final int n = palindrome.length();
        for (int i = 0; i < n / 2; i++) {
            if (palindrome.charAt(i) != 'a') {
                chars[i] = 'a';
                return new String(chars);
            }
        }
        chars[n - 1] = 'b';
        return n == 1 ? "" : new String(chars);
    }
}
