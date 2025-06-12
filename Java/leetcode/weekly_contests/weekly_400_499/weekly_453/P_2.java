package leetcode.weekly_contests.weekly_400_499.weekly_453;

public class P_2 {

    private static final int MOD = (int) (1e9 + 7);

    public int countPermutations(int[] complexity) {
        long res = 1;
        for (int i = 1; i < complexity.length; i++) {
            if (complexity[0] >= complexity[i]) {
                return 0;
            }
            res = (res * i) % MOD;
        }
        return (int) res;
    }
}
