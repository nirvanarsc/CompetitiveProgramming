package leetcode.weekly_contests.weekly_200_299.weekly_222;

public class P_1711 {

    private static final int MOD = (int) 1e9 + 7;

    public int countPairs(int[] deliciousness) {
        final boolean[] seen = new boolean[(1 << 21) + 5];
        final int[] freq = new int[(1 << 21) + 5];
        for (int num : deliciousness) {
            freq[num]++;
        }
        long res = 0;
        for (int j = 0; j < freq.length; j++) {
            if (freq[j] == 0) {
                continue;
            }
            for (int i = 0; i < 22; i++) {
                final int complement = (1 << i) - j;
                if (complement < 0 || seen[complement]) {
                    continue;
                }
                final long add;
                if (complement == j) {
                    add = ((long) freq[j] * (freq[j] - 1)) / 2;
                } else {
                    add = (long) freq[j] * freq[complement];
                }
                res = (res + add) % MOD;
            }
            seen[j] = true;
        }
        return (int) res;
    }
}
