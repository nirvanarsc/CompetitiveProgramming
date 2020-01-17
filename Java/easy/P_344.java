package easy;

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
}
