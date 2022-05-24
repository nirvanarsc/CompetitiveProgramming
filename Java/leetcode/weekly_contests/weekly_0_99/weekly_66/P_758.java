package leetcode.weekly_contests.weekly_0_99.weekly_66;

import java.util.Arrays;

public class P_758 {

    @SuppressWarnings("MethodParameterNamingConvention")
    public String boldWords(String[] words, String S) {
        final boolean[] bold = new boolean[S.length() + 1];
        for (String w : words) {
            int start = S.indexOf(w);
            while (start != -1) {
                Arrays.fill(bold, start, start + w.length(), true);
                start = S.indexOf(w, start + 1);
            }
        }
        final StringBuilder r = new StringBuilder().append(bold[0] ? "<b>" : "");
        for (int i = 0; i < bold.length - 1; i++) {
            r.append(S.charAt(i));
            if (!bold[i] && bold[i + 1]) {
                r.append("<b>");
            } else if (bold[i] && !bold[i + 1]) {
                r.append("</b>");
            }
        }
        return r.toString();
    }
}
