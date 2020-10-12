package leetcode.medium;

public class P_186 {

    public void reverseWords(char[] s) {
        reverse(0, s.length - 1, s);
        int prev = 0;
        for (int i = 0; i < s.length; i++) {
            if (s[i] == ' ') {
                reverse(prev, i - 1, s);
                prev = i + 1;
            }
        }
        reverse(prev, s.length - 1, s);
    }

    private static void reverse(int from, int to, char[] chars) {
        for (int i = from; 2 * i < to + from; i++) {
            final char temp = chars[i];
            chars[i] = chars[to + from - i];
            chars[to + from - i] = temp;
        }
    }
}
