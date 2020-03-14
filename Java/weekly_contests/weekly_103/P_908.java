package weekly_contests.weekly_103;

public class P_908 {

    @SuppressWarnings("MethodParameterNamingConvention")
    public int smallestRangeI(int[] A, int K) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int num : A) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        return Math.max(0, max - min - 2*K);
    }
}
