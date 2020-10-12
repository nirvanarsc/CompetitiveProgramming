package leetcode.weekly_contests.weekly_69;

import java.util.HashMap;
import java.util.Map;

public class P_771 {

    @SuppressWarnings("MethodParameterNamingConvention")
    public int numJewelsInStones(String J, String S) {
        final Map<Character, Integer> map = new HashMap<>();
        for (char c : S.toCharArray()) {
            map.merge(c, 1, Integer::sum);
        }
        int res = 0;
        for (char c : J.toCharArray()) {
            res += map.getOrDefault(c, 0);
        }
        return res;
    }
}
