package leetcode.biweekly_contests.biweekly_0_99.biweekly_70;

public class P_4 {

    private static final int MOD = (int) (1e9 + 7);

    public int numberOfWays(String corridor) {
        final int n = corridor.length();
        final char[] w = corridor.toCharArray();
        int s = 0;
        for (int i = 0; i < n; i++) {
            if (w[i] == 'S') {
                s++;
            }
        }
        if (s == 0 || s % 2 != 0) {
            return 0;
        }
        int currS = 0;
        long res = 1;
        for (int i = 0; i < n; i++) {
            if (w[i] == 'S') {
                currS++;
            }
            if (currS > 0 && currS < s && currS % 2 == 0) {
                int j = i + 1;
                while (j < n && w[j] == 'P') {
                    j++;
                }
                res = (res * (j - i)) % MOD;
                i = j - 1;
            }
        }
        return (int) res;
    }
}
