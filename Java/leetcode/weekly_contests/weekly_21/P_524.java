package leetcode.weekly_contests.weekly_21;

import java.util.List;

public class P_524 {

    public String findLongestWord(String s, List<String> d) {
        return d.stream()
                .filter(word -> isSubsequence(s, word))
                .max((a, b) -> a.length() == b.length() ? b.compareTo(a)
                                                        : Integer.compare(a.length(), b.length()))
                .orElse("");
    }

    private static boolean isSubsequence(String a, String b) {
        int j = 0;
        for (int i = 0; i < a.length(); i++) {
            if (j < b.length() && a.charAt(i) == b.charAt(j)) {
                j++;
            }
        }
        return j == b.length();
    }
}
