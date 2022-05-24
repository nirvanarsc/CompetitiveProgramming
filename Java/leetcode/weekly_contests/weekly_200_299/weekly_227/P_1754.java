package leetcode.weekly_contests.weekly_200_299.weekly_227;

public class P_1754 {

    public String largestMerge(String word1, String word2) {
        final char[] s1 = word1.toCharArray();
        final char[] s2 = word2.toCharArray();
        final StringBuilder sb = new StringBuilder();
        int l = 0;
        int r = 0;
        while (l < word1.length() || r < word2.length()) {
            if (l < word1.length() && r < word2.length()) {
                if (word1.substring(l).compareTo(word2.substring(r)) <= 0) {
                    sb.append(s2[r++]);
                } else {
                    sb.append(s1[l++]);
                }
            } else if (l < word1.length()) {
                sb.append(s1[l++]);
            } else {
                sb.append(s2[r++]);
            }
        }
        return sb.toString();
    }
}
