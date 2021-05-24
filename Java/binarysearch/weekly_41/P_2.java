package binarysearch.weekly_41;

public class P_2 {

    public int solve(String s, String t) {
        final int[][] mismatches = new int[26][26];
        int total = 0;
        final char[] l = s.toCharArray();
        final char[] r = t.toCharArray();
        final int n = s.length();
        for (int i = 0; i < n; i++) {
            if (l[i] != r[i]) {
                mismatches[l[i] - 'a'][r[i] - 'a']++;
                total++;
            }
        }
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                if (mismatches[i][j] > 0 && mismatches[j][i] > 0) {
                    return total - 2;
                }
            }
        }
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                if (mismatches[i][j] > 0) {
                    for (int k = 0; k < 26; k++) {
                        if (mismatches[j][k] > 0) {
                            return total - 1;
                        }
                    }
                }
            }
        }
        return total;
    }
}
