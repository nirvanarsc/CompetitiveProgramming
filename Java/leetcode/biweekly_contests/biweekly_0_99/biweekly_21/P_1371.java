package leetcode.biweekly_contests.biweekly_0_99.biweekly_21;

import java.util.HashMap;
import java.util.Map;

public class P_1371 {

    public int findTheLongestSubstring(String s) {
        int res = 0, cur = 0;
        final int n = s.length();
        final Map<Integer, Integer> seen = new HashMap<>();
        seen.put(0, -1);
        for (int i = 0; i < n; ++i) {
            cur ^= 1 << ("aeiou".indexOf(s.charAt(i)) + 1) >> 1;
            seen.putIfAbsent(cur, i);
            res = Math.max(res, i - seen.get(cur));
        }
        return res;
    }

    public int findTheLongestSubstringMap(String s) {
        final Map<Integer, Integer> map = new HashMap<>();
        final char[] v = { 'a', 'e', 'i', 'o', 'u' };
        int answer = 0;
        int mask = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < v.length; j++) {
                if (s.charAt(i) == v[j]) {
                    mask ^= 1 << j;
                }
            }
            if (mask == 0) {
                answer = Math.max(answer, i + 1);
            }
            if (map.containsKey(mask)) {
                answer = Math.max(answer, i - map.get(mask));
            } else {
                map.put(mask, i);
            }
        }
        return answer;
    }
}
