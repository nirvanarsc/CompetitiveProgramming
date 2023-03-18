package leetcode.biweekly_contests.biweekly_0_99.biweekly_52;

public class P_1862 {

    private static final int MAX = (int) (2e5 + 5);
    private static final int MOD = (int) (1e9 + 7);

    public int sumOfFlooredPairs(int[] nums) {
        final int[] freq = new int[MAX];
        final int[] pre = new int[MAX + 1];
        for (int num : nums) {
            freq[num]++;
        }
        for (int i = 1; i <= MAX; i++) {
            pre[i] = pre[i - 1] + freq[i - 1];
        }
        final int n = (int) (1e5 + 5);
        long res = 0;
        for (int i = 1; i < n; i++) {
            if (freq[i] == 0) {
                continue;
            }
            for (int j = i, mul = 1; j < n; j += i, mul++) {
                long add = pre[j + i] - pre[j];
                add = (add * mul) % MOD;
                add = (add * freq[i]) % MOD;
                res = (res + add) % MOD;
            }
        }
        return (int) res;
    }
}
