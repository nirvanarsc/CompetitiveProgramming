package leetcode.weekly_contests.weekly_105;

public class P_917 {

    public String reverseOnlyLetters(String s) {
        int i = 0;
        int j = s.length() - 1;
        final char[] res = s.toCharArray();
        while (i < j) {
            if (!isLetter(res[i])) {
                i++;
            } else if (!isLetter(res[j])) {
                j--;
            } else {
                final char t = res[i];
                res[i] = res[j];
                res[j] = t;
                i++;
                j--;
            }
        }
        return new String(res);
    }

    private static boolean isLetter(char c) {
        return ('a' <= c && c <= 'z') || ('A' <= c && c <= 'Z');
    }
}
