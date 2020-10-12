package leetcode.biweekly_contests.biweekly_31;

public class P_1524 {

    private static final int MOD = (int) (1e9 + 7);

    public int numOfSubarrays(int[] arr) {
        int even = 0;
        int odd = 1;
        int sum = 0, res = 0;
        for (int num : arr) {
            sum = (sum + num) % 2;
            if (sum % 2 != 0) {
                res = (res + odd) % MOD;
                even++;
            } else {
                res = (res + even) % MOD;
                odd++;
            }
        }
        return res;
    }
}
