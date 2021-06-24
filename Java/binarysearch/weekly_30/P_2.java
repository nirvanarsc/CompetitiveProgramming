package binarysearch.weekly_30;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

@SuppressWarnings({ "InnerClassMayBeStatic", "PublicConstructorInNonPublicClass", "unused" })
public class P_2 {

    class StockMarket {

        TreeMap<Integer, TreeSet<String>> tm = new TreeMap<>(Comparator.reverseOrder());
        Map<String, Integer> map = new HashMap<>();

        public StockMarket(String[] stocks, int[] amounts) {
            for (int i = 0; i < stocks.length; i++) {
                map.merge(stocks[i], amounts[i], Integer::sum);
            }
            for (Map.Entry<String, Integer> e : map.entrySet()) {
                tm.computeIfAbsent(e.getValue(), val -> new TreeSet<>()).add(e.getKey());
            }
        }

        public void add(String s, int amount) {
            final int prev = map.getOrDefault(s, -1);
            if (prev != -1) {
                tm.get(prev).remove(s);
            }
            final int curr = map.merge(s, amount, Integer::sum);
            tm.computeIfAbsent(curr, val -> new TreeSet<>()).add(s);
        }

        public String[] top(int k) {
            final Iterator<Map.Entry<Integer, TreeSet<String>>> iterator = tm.entrySet().iterator();
            final String[] res = new String[k];
            int idx = 0;
            while (idx < k) {
                final TreeSet<String> next = iterator.next().getValue();
                final Iterator<String> tsIterator = next.iterator();
                while (tsIterator.hasNext() && idx < k) {
                    res[idx++] = tsIterator.next();
                }
            }
            return res;
        }
    }
}
