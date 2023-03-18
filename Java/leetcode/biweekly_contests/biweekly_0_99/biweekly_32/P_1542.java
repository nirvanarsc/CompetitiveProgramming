package leetcode.biweekly_contests.biweekly_0_99.biweekly_32;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class P_1542 {

    public int longestAwesome(String s) {
        final Map<Integer, Integer> map = new HashMap<>(Collections.singletonMap(0, -1));
        int res = 0, curr = 0;
        final char[] str = s.toCharArray();
        for (int i = 0; i < str.length; i++) {
            curr ^= 1 << (str[i] - '0');
            res = Math.max(res, i - map.getOrDefault(curr, i));
            for (int j = 0; j < 10; j++) {
                final int complement = (1 << j) ^ curr;
                res = Math.max(res, i - map.getOrDefault(complement, i));
            }
            map.putIfAbsent(curr, i);
        }
        return res;
    }
}
