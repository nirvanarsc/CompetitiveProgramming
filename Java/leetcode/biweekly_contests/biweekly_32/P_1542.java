package leetcode.biweekly_contests.biweekly_32;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class P_1542 {

    public int longestAwesome(String s) {
        final Map<Integer, Integer> idx = new HashMap<>(Collections.singletonMap(0, -1));
        int res = 0, mask = 0;
        for (int i = 0; i < s.length(); i++) {
            mask ^= 1 << (s.charAt(i) - '0');
            idx.putIfAbsent(mask, i);
            res = Math.max(res, i - idx.getOrDefault(mask, i));
            for (int value = 1; value <= (1 << 10); value <<= 1) {
                final int complement = value ^ mask;
                res = Math.max(res, i - idx.getOrDefault(complement, i));
            }
        }
        return res;
    }
}
