package weekly_contests.weekly_67;

import java.util.ArrayList;
import java.util.List;

public class P_763 {

    @SuppressWarnings("MethodParameterNamingConvention")
    public List<Integer> partitionLabels(String S) {
        final int[] endIdx = new int[26];
        for (int i = 0; i < S.length(); i++) {
            endIdx[S.charAt(i) - 'a'] = i;
        }
        final List<Integer> res = new ArrayList<>();
        int prev = -1, curr = -1;
        for (int i = 0; i < S.length(); i++) {
            curr = Math.max(curr, endIdx[S.charAt(i) - 'a']);
            if (curr == i) {
                res.add(i - prev);
                prev = i;
                curr = -1;
            }
        }
        return res;
    }
}
