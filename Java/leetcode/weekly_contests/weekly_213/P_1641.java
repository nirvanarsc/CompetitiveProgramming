package leetcode.weekly_contests.weekly_213;

public class P_1641 {

    public int countVowelStrings(int n) {
        final int[] res = { 1, 1, 1, 1, 1 };
        for (int i = 2; i <= n; i++) {
            for (int j = res.length - 2; j >= 0; j--) {
                res[j] += res[j + 1];
            }
        }
        int sum = 0;
        for (int val : res) {
            sum += val;
        }
        return sum;
    }
}
