package leetcode.weekly_contests.weekly_100_199.weekly_103;

@SuppressWarnings("MethodParameterNamingConvention")
public class P_908 {

    public int smallestRangeI(int[] A, int K) {
        int max = 0;
        int min = (int) 1e9;
        for (int num : A) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        return Math.max(0, max - min - 2 * K);
    }
}
