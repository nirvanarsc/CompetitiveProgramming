package leetcode.biweekly_contests.biweekly_65;

public class P_1 {

    public boolean checkAlmostEquivalent(String word1, String word2) {
        final int[] f = new int[26];
        for (char c : word1.toCharArray()) {
            f[c - 'a']++;
        }
        for (char c : word2.toCharArray()) {
            f[c - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (f[i] < -3 || f[i] > 3) {
                return false;
            }
        }
        return true;
    }
}
