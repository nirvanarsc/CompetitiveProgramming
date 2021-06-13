package leetcode.weekly_contests.weekly_245;

public class P_1 {

    public boolean makeEqual(String[] words) {
        final int[] map = new int[26];
        for (String w : words) {
            for (char c : w.toCharArray()) {
                map[c - 'a']++;
            }
        }
        final int n = words.length;
        for (int i = 0; i < 26; i++) {
            if (map[i] % n != 0) {
                return false;
            }
        }
        return true;
    }
}
