package leetcode.easy;

public class P_344 {

    public void reverseString(char[] s) {
        for (int start = 0, end = s.length - 1; start < end; start++, end--) {
            if (s[start] != s[end]) {
                s[start] ^= s[end];
                s[end] ^= s[start];
                s[start] ^= s[end];
            }
        }
    }

    public void reverseStringR(char[] s) {
        helper(s, 0, s.length - 1);
    }

    private static void helper(char[] s, int start, int end) {
        if (start >= end) {
            return;
        }
        if (s[start] != s[end]) {
            s[start] ^= s[end];
            s[end] ^= s[start];
            s[start] ^= s[end];
        }
        helper(s, start + 1, end - 1);
    }
}
