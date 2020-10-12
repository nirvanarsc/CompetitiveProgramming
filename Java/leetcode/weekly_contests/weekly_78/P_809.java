package leetcode.weekly_contests.weekly_78;

@SuppressWarnings("MethodParameterNamingConvention")
public class P_809 {

    public int expressiveWords(String S, String[] words) {
        int res = 0;
        for (String w : words) {
            if (isStretchy(S, w)) {
                res++;
            }
        }
        return res;
    }

    public static boolean isStretchy(String S, String word) {
        int i = 0, j = 0;
        while (i < S.length() && j < word.length()) {
            if (S.charAt(i) == word.charAt(j)) {
                final int len1 = getRepeatedLength(S, i);
                final int len2 = getRepeatedLength(word, j);
                if (len1 < 3 && len1 != len2 || len1 >= 3 && len1 < len2) {
                    return false;
                }
                i += len1;
                j += len2;
            } else {
                return false;
            }
        }
        return i == S.length() && j == word.length();
    }

    public static int getRepeatedLength(String str, int i) {
        int t = i;
        while (t < str.length() && str.charAt(t) == str.charAt(i)) {
            t++;
        }
        return t - i;
    }
}
