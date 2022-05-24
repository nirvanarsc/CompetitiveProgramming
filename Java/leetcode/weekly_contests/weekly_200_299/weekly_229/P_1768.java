package leetcode.weekly_contests.weekly_200_299.weekly_229;

public class P_1768 {

    public String mergeAlternately(String word1, String word2) {
        final StringBuilder sb = new StringBuilder();
        int i = 0;
        int j = 0;
        boolean turn = true;
        while (i < word1.length() || j < word2.length()) {
            if (turn) {
                if (i < word1.length()) {
                    sb.append(word1.charAt(i++));
                } else {
                    sb.append(word2.charAt(j++));
                }
            } else {
                if (j < word2.length()) {
                    sb.append(word2.charAt(j++));
                } else {
                    sb.append(word1.charAt(i++));
                }
            }
            turn ^= true;
        }
        return sb.toString();
    }
}
