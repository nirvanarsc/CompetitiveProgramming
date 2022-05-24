package leetcode.weekly_contests.weekly_0_99.weekly_7;

public class P_408 {

    public boolean validWordAbbreviation(String word, String abbr) {
        int j = 0;
        for (int i = 0; i < abbr.length(); i++) {
            if (Character.isLetter(abbr.charAt(i))) {
                if (j >= word.length() || word.charAt(j) != abbr.charAt(i)) {
                    return false;
                } else {
                    j++;
                }
            } else if (abbr.charAt(i) == '0') {
                return false;
            } else {
                int t = i;
                int skip = 0;
                while (t < abbr.length() && Character.isDigit(abbr.charAt(t))) {
                    skip = skip * 10 + abbr.charAt(t) - '0';
                    t++;
                }
                i = t - 1;
                j += skip;
            }
        }
        return j == word.length();
    }
}
