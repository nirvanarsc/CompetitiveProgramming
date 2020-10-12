package leetcode.weekly_contests.weekly_112;

import java.util.Arrays;

public class P_945 {

    @SuppressWarnings("MethodParameterNamingConvention")
    public int minIncrementForUnique(int[] A) {
        Arrays.sort(A);
        int res = 0, next = 0;
        for (int a : A) {
            res += Math.max(next - a, 0);
            next = Math.max(a, next) + 1;
        }
        return res;
    }
}
