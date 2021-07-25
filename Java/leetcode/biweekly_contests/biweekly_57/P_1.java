package leetcode.biweekly_contests.biweekly_57;

public class P_1 {

    public boolean areOccurrencesEqual(String s) {
        final int[] map = new int[26];
        for (char c : s.toCharArray()) {
            map[c - 'a']++;
        }
        int f = -1;
        for (int i = 0; i < 26; i++) {
            if (map[i] > 0 && f == -1) {
                f = map[i];
            } else if (map[i] > 0 && f != map[i]) {
                return false;
            }
        }
        return true;
    }
}
