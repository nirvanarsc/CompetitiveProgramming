package leetcode.weekly_contests.weekly_150;

public class P_1160 {

    public int countCharacters(String[] words, String chars) {
        int res = 0;
        final int[] map = new int[26];
        for (char c : chars.toCharArray()) {
            map[c - 'a']++;
        }
        for (String w : words) {
            if (check(w, map)) {
                res += w.length();
            }
        }
        return res;
    }

    private static boolean check(String w, int[] map) {
        map = map.clone();
        for (char c : w.toCharArray()) {
            if (map[c - 'a'] == 0) {
                return false;
            }
            map[c - 'a']--;
        }
        return true;
    }
}
