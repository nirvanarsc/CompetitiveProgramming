package leetcode.weekly_contests.weekly_200_299.weekly_216;

public class P_1662 {

    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        int i = 0;
        int j = 0;
        int l = 0;
        int r = 0;
        while (i < word1.length && j < word2.length) {
            while (l < word1[i].length() && r < word2[j].length() && word1[i].charAt(l) == word2[j].charAt(r)) {
                l++;
                r++;
            }
            if (l != word1[i].length() && r != word2[j].length()) {
                return false;
            }
            if (l == word1[i].length()) {
                l = 0;
                i++;
            }
            if (r == word2[j].length()) {
                r = 0;
                j++;
            }
        }
        return i == word1.length && j == word2.length;
    }
}
