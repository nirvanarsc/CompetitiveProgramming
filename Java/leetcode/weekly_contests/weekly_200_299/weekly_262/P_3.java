package leetcode.weekly_contests.weekly_200_299.weekly_262;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

@SuppressWarnings({ "InnerClassMayBeStatic", "PublicConstructorInNonPublicClass", "unused" })
public class P_3 {

    class StockPrice {

        TreeMap<Integer, Integer> tm;
        Map<Integer, Integer> map;
        int maxTimestamp;

        public StockPrice() {
            tm = new TreeMap<>();
            map = new HashMap<>();
        }

        public void update(int timestamp, int price) {
            final Integer prev = map.put(timestamp, price);
            if (prev != null) {
                final Integer updated = tm.merge(prev, -1, Integer::sum);
                if (updated == 0) {
                    tm.remove(prev);
                }
            }
            tm.merge(price, 1, Integer::sum);
            maxTimestamp = Math.max(maxTimestamp, timestamp);
        }

        public int current() {
            return map.get(maxTimestamp);
        }

        public int maximum() {
            return tm.lastKey();
        }

        public int minimum() {
            return tm.firstKey();
        }
    }
}
