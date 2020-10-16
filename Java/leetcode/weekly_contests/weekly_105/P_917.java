package leetcode.weekly_contests.weekly_105;

@SuppressWarnings("MethodParameterNamingConvention")
public class P_917 {

    public String reverseOnlyLetters(String S) {
        int i = 0;
        int j = S.length() - 1;
        final char[] res = S.toCharArray();
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
