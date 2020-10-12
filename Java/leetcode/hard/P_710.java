package leetcode.hard;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@SuppressWarnings({ "MethodParameterNamingConvention", "unused" })
public class P_710 {

    static class Solution {

        Map<Integer, Integer> map;
        Random r;
        int range;

        Solution(int N, int[] blacklist) {
            map = new HashMap<>();
            for (int b : blacklist) {
                map.put(b, -1);
            }
            range = N - map.size();
            N--;
            for (int b : blacklist) {
                if (b < range) {
                    while (map.containsKey(N)) {
                        N--;
                    }
                    map.put(b, N--);
                }
            }
            r = new Random();
        }

        public int pick() {
            final int p = r.nextInt(range);
            return map.getOrDefault(p, p);
        }
    }
}
