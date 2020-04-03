package weekly_contests.weekly_67;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P_763 {

    @SuppressWarnings("MethodParameterNamingConvention")
    public List<Integer> partitionLabels(String S) {
        final Map<Character, Integer> lastIndex = new HashMap<>();
        for (int i = 0; i < S.length(); i++) {
            lastIndex.put(S.charAt(i), i);
        }
        int currMax = 0, prevStart = -1;
        final List<Integer> res = new ArrayList<>();
        for (int i = 0; i < S.length(); i++) {
            currMax = Math.max(currMax, lastIndex.get(S.charAt(i)));
            if (i == currMax) {
                res.add(i - prevStart);
                prevStart = i;
            }
        }
        return res;
    }
}
