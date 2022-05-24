package leetcode.weekly_contests.weekly_200_299.weekly_215;

import java.util.Arrays;

public class P_1657 {

    public boolean closeStrings(String word1, String word2) {
        final int[] freq1 = new int[26];
        final int[] freq2 = new int[26];
        for (char c : word1.toCharArray()) {
            freq1[c - 'a']++;
        }
        for (char c : word2.toCharArray()) {
            freq2[c - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if ((freq1[i] > 0) ^ (freq2[i] > 0)) {
                return false;
            }
        }
        Arrays.sort(freq1);
        Arrays.sort(freq2);
        return Arrays.equals(freq1, freq2);
    }
}
