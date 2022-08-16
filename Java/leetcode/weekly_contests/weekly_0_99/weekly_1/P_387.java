package leetcode.weekly_contests.weekly_0_99.weekly_1;

public class P_387 {

    public int firstUniqChar(String s) {
        final char[] w = s.toCharArray();
        final int n = w.length;
        final int[] f = new int[26];
        for (char c : w) {
            f[c - 'a']++;
        }
        for (int i = 0; i < n; i++) {
            if (f[w[i] - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}
