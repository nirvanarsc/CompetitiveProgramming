package leetcode.weekly_contests.weekly_1;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("DynamicRegexReplaceableByCompiledPattern")
public class P_388 {

    public int lengthLongestPath(String input) {
        int res = 0;
        final Map<Integer, Integer> lengths = new HashMap<>();
        for (String p : input.split("\\n")) {
            int j = 0;
            while (p.charAt(j) == '\t') {
                j++;
            }
            final int currL = 1 + p.length() - j + lengths.getOrDefault(j - 1, 0);
            if (p.indexOf('.') != -1) {
                res = Math.max(res, currL - 1);
            } else {
                lengths.put(j, currL);
            }
        }
        return res;
    }
}
