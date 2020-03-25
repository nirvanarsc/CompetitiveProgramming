package weekly_contests.weekly_83;

public class P_829 {

    @SuppressWarnings("MethodParameterNamingConvention")
    public int consecutiveNumbersSum(int N) {
        int count = 1;
        for (int k = 2; k < Math.sqrt(2 * N); k++) {
            if ((N - (k * (k - 1) / 2)) % k == 0) {
                count++;
            }
        }
        return count;
    }
}
