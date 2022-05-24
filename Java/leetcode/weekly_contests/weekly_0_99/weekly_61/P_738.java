package leetcode.weekly_contests.weekly_0_99.weekly_61;

import java.util.Arrays;

public class P_738 {

    @SuppressWarnings("MethodParameterNamingConvention")
    public int monotoneIncreasingDigits(int N) {
        final char[] str = String.valueOf(N).toCharArray();
        for (int j = 0; j < str.length - 1; j++) {
            if (str[j] > str[j + 1]) {
                int t = j;
                while (t >= 0 && str[t] == str[j]) {
                    t--;
                }
                str[t + 1]--;
                Arrays.fill(str, t + 2, str.length, '9');
            }
        }
        return Integer.valueOf(new String(str));
    }
}
