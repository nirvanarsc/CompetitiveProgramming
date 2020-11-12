package leetcode.hard;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;

@SuppressWarnings({ "MethodParameterNamingConvention", "InnerClassMayBeStatic", "unused" })
public class P_710 {

    class SolutionMap {
        Map<Integer, Integer> map;
        Random r;
        int range;

        SolutionMap(int N, int[] blacklist) {
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

    class Solution {
        Random r;
        Map<Integer, Integer> banned;
        int limit;

        Solution(int N, int[] blacklist) {
            Arrays.sort(blacklist);
            r = new Random();
            banned = new HashMap<>();
            limit = N - blacklist.length;
            final Set<Integer> set = new HashSet<>();
            for (int num : blacklist) {
                set.add(num);
            }
            for (int i = limit, j = 0, k = 0; k < blacklist.length; k++, i++) {
                if (set.contains(i)) {
                    continue;
                }
                banned.put(blacklist[j++], i);
            }
        }

        public int pick() {
            final int num = r.nextInt(limit);
            return banned.getOrDefault(num, num);
        }
    }
}
