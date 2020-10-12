package leetcode.weekly_contests.weekly_74;

public class P_795 {

    @SuppressWarnings("MethodParameterNamingConvention")
    public int numSubarrayBoundedMax(int[] A, int L, int R) {
        int i = 0, j = 0, res = 0;
        for (int num : A) {
            i = num < L ? i + 1 : 0;
            j = num <= R ? j + 1 : 0;
            res += j - i;
        }
        return res;
    }
}
