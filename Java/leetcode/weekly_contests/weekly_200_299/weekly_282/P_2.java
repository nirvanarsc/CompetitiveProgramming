package leetcode.weekly_contests.weekly_200_299.weekly_282;

public class P_2 {

    public int minSteps(String s, String t) {
        final int[] f1 = new int[26];
        final int[] f2 = new int[26];
        for (char c : s.toCharArray()) {
            f1[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            f2[c - 'a']++;
        }
        int res = 0;
        for (int i = 0; i < 26; i++) {
            res += Math.abs(f1[i] - f2[i]);
        }
        return res;
    }
}
