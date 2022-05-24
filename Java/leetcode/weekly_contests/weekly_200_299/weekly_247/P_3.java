package leetcode.weekly_contests.weekly_200_299.weekly_247;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class P_3 {

    public long wonderfulSubstrings(String word) {
        long res = 0;
        final Map<Integer, Long> map = new HashMap<>(Collections.singletonMap(0, 1L));
        int curr = 0;
        final int n = word.length();
        for (int i = 0; i < n; i++) {
            curr ^= 1 << word.charAt(i) - 'a';
            for (int j = 0; j < 10; j++) {
                final int check = 1 << j;
                final int complement = curr ^ check;
                res += map.getOrDefault(complement, 0L);
            }
            res += map.getOrDefault(curr, 0L);
            map.merge(curr, 1L, Long::sum);
        }
        return res;
    }
}
