package leetcode.weekly_contests.weekly_0_99.weekly_36;

public class P_616 {

    public String addBoldTag(String s, String[] dict) {
        final boolean[] bold = new boolean[s.length()];
        for (int i = 0, end = 0; i < s.length(); i++) {
            for (String word : dict) {
                if (s.startsWith(word, i)) {
                    end = Math.max(end, i + word.length());
                }
            }
            bold[i] = end > i;
        }
        final StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (bold[i]) {
                int j = i;
                while (j < s.length() && bold[j]) {
                    j++;
                }
                result.append("<b>" + s.substring(i, j) + "</b>");
                i = j - 1;
            } else {
                result.append(s.charAt(i));
            }
        }
        return result.toString();
    }
}
