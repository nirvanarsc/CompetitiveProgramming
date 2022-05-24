package leetcode.weekly_contests.weekly_100_199.weekly_175;

public class P_1347 {

    public int minSteps(String s, String t) {
        final int[] map = new int[26];
        for (char c : s.toCharArray()) {
            map[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            if (map[c - 'a'] > 0) {
                map[c - 'a']--;
            }
        }
        int res = 0;
        for (int value : map) {
            if (value > 0) {
                res += value;
            }
        }
        return res;
    }
}
