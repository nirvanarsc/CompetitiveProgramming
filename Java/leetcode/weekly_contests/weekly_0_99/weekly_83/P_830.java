package leetcode.weekly_contests.weekly_0_99.weekly_83;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P_830 {

    @SuppressWarnings("MethodParameterNamingConvention")
    public List<List<Integer>> largeGroupPositions(String S) {
        final List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < S.length(); i++) {
            int j = i;
            final char c = S.charAt(i);
            while (j < S.length() && S.charAt(j) == c) {
                j++;
            }
            if (j - i >= 3) {
                res.add(Arrays.asList(i, j - 1));
                i = j - 1;
            }
        }
        return res;
    }
}
