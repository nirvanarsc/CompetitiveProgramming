package leetcode.hard;

import java.util.LinkedHashMap;
import java.util.Map;

public class P_340 {

    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        final int[] count = new int[256];
        int num = 0, i = 0, res = 0;
        for (int j = 0; j < s.length(); j++) {
            if (count[s.charAt(j)]++ == 0) {
                num++;
            }
            while (num > k) {
                if (--count[s.charAt(i)] == 0) {
                    num--;
                }
                i++;
            }
            res = Math.max(res, j - i + 1);
        }
        return res;
    }

    public int lengthOfLongestSubstringKDistinctLHM(String s, int k) {
        if (k == 0) {
            return 0;
        }
        int lo = 0, hi = 0, max = 0;
        final int n = s.length();
        final Map<Character, Integer> map = new LinkedHashMap<>();

        while (hi < n) {
            final char curr = s.charAt(hi);
            if (map.containsKey(curr) || map.size() < k) {
                map.remove(curr);
                map.put(curr, hi);
                max = Math.max(max, hi++ - lo + 1);
            } else {
                final Character leftmost = map.keySet().iterator().next();
                lo = map.get(leftmost);
                map.remove(leftmost);
                lo++;
            }
        }
        return max;
    }
}
