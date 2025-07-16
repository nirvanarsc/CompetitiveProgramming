package leetcode.biweekly_contests.biweekly_100_199.biweekly_156;

public class P_1 {

    public int maxFreqSum(String s) {
        final int[] f = new int[26];
        for (char c : s.toCharArray()) {
            f[c - 'a']++;
        }
        int l = 0;
        int r = 0;
        for (int i = 0; i < f.length; i++) {
            if (i == 0 || i == 4 || i == 8 || i == 14 || i == 20) {
                l = Math.max(l, f[i]);
            } else {
                r = Math.max(r, f[i]);
            }
        }
        return l + r;
    }
}
