package medium;

import java.util.HashMap;
import java.util.Map;

public class P_159 {

    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int res = 0, i = 0;
        final Map<Character, Integer> map = new HashMap<>();
        for (int j = 0; j < s.length(); j++) {
            map.merge(s.charAt(j), 1, Integer::sum);
            while (map.size() > 2) {
                map.merge(s.charAt(i), -1, Integer::sum);
                if (map.get(s.charAt(i)) == 0) {
                    map.remove(s.charAt(i));
                }
                i++;
            }
            res = Math.max(res, j - i + 1);
        }
        return res;
    }
}
