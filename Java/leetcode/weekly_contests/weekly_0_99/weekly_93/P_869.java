package leetcode.weekly_contests.weekly_0_99.weekly_93;

import java.util.Arrays;

@SuppressWarnings("MethodParameterNamingConvention")
public class P_869 {

    public boolean reorderedPowerOf2(int N) {
        final int[] map = f(N);
        for (int i = 0; i < 31; i++) {
            if (Arrays.equals(map, f(1 << i))) {
                return true;
            }
        }
        return false;
    }

    private static int[] f(int n) {
        final int[] map = new int[10];
        while (n > 0) {
            map[n % 10]++;
            n /= 10;
        }
        return map;
    }
}
