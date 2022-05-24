package leetcode.weekly_contests.weekly_0_99.weekly_30;

public class P_567 {

    public boolean checkInclusion(String s1, String s2) {
        final int[] map = new int[26];
        for (char c : s1.toCharArray()) {
            map[c - 'a']++;
        }
        final int n = s1.length();
        final int m = s2.length();
        final char[] w = s2.toCharArray();
        int j = 0, curr = n;
        for (int i = 0; i < m; i++) {
            if (map[w[i] - 'a']-- > 0) {
                curr--;
            }
            while (curr == 0) {
                if (i - j + 1 == n) {
                    return true;
                }
                if (++map[w[j++] - 'a'] > 0) {
                    curr++;
                }
            }
        }
        return false;
    }
}
