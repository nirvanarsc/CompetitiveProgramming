package leetcode.biweekly_contests.biweekly_0_99.biweekly_47;

public class P_1781 {

    public int beautySum(String s) {
        int res = 0;
        final char[] w = s.toCharArray();
        final int n = w.length;
        final int[][] pres = new int[26][n + 1];
        for (char c = 'a'; c <= 'z'; c++) {
            for (int i = 1; i <= n; i++) {
                pres[c - 'a'][i] = pres[c - 'a'][i - 1] + (w[i - 1] == c ? 1 : 0);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int min = 505;
                int max = 0;
                for (char c = 'a'; c <= 'z'; c++) {
                    if (pres[c - 'a'][j + 1] - pres[c - 'a'][i] > 0) {
                        max = Math.max(max, pres[c - 'a'][j + 1] - pres[c - 'a'][i]);
                        min = Math.min(min, pres[c - 'a'][j + 1] - pres[c - 'a'][i]);
                    }

                }
                res += max - min;
            }
        }
        return res;
    }
}
