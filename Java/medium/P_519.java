package medium;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@SuppressWarnings("unused")
public class P_519 {

    static class Solution {
        Map<Integer, Integer> map;
        Random r;
        int x, y, currTotal;

        Solution(int n_rows, int n_cols) {
            map = new HashMap<>();
            r = new Random();
            x = n_rows;
            y = n_cols;
            currTotal = x * y;
        }

        public int[] flip() {
            final int random = r.nextInt(currTotal--);
            final int res = map.getOrDefault(random, random);
            map.put(random, map.getOrDefault(currTotal, currTotal));
            return getIndex(res);
        }

        public void reset() {
            map = new HashMap<>();
            currTotal = x * y;
        }

        private int[] getIndex(int num) {
            return new int[] { num / y, num % y };
        }
    }
}
