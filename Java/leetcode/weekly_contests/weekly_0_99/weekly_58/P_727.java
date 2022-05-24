package leetcode.weekly_contests.weekly_0_99.weekly_58;

@SuppressWarnings("MethodParameterNamingConvention")
public class P_727 {

    public String minWindow(String S, String T) {
        final char[] s = S.toCharArray();
        final char[] t = T.toCharArray();
        int j = 0, start = -1, end = -1, len = s.length;
        for (int i = 0; i < s.length; i++) {
            if (s[i] == t[j] && ++j == t.length) {
                final int currEnd = i + 1;
                j--;
                while (j >= 0) {
                    if (s[i] == t[j]) {
                        j--;
                    }
                    i--;
                }
                i++;
                j++;
                if (currEnd - i < len) {
                    len = currEnd - i;
                    start = i;
                    end = currEnd;
                }
            }
        }
        return start == -1 ? "" : S.substring(start, end);
    }
}
