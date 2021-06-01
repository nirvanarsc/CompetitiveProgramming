package binarysearch.weekly_36;

public class P_2 {

    public int solve(String s) {
        final int n = s.length();
        final int[] fL = new int[26];
        final int[] fR = new int[26];
        final char[] w = s.toCharArray();
        for (int i = 0, j = n / 2; i < n / 2; i++, j++) {
            fL[w[i] - 'a']++;
            fR[w[j] - 'a']++;
        }
        int res = n;
        for (int i = 1; i < 26; i++) {
            int curr = 0;
            for (int j = 0; j < i; j++) {
                curr += fL[j];
            }
            for (int j = i; j < 26; j++) {
                curr += fR[j];
            }
            res = Math.min(res, curr);
        }
        for (int i = 0; i < 25; i++) {
            int curr = 0;
            for (int j = 0; j < i; j++) {
                curr += fR[j];
            }
            for (int j = i; j < 26; j++) {
                curr += fL[j];
            }
            res = Math.min(res, curr);
        }
        int eq = 0;
        for (int i = 0; i < 26; i++) {
            eq = Math.max(eq, fL[i] + fR[i]);
        }
        return Math.min(res, n - eq);
    }
}
