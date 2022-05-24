package leetcode.weekly_contests.weekly_200_299.weekly_268;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

@SuppressWarnings({ "InnerClassMayBeStatic", "PublicConstructorInNonPublicClass", "unused" })
public class P_3 {

    class RangeFreqQuery {

        Map<Integer, Integer> freq;
        Map<Integer, TreeMap<Integer, Integer>> tms;

        public RangeFreqQuery(int[] arr) {
            freq = new HashMap<>();
            tms = new HashMap<>();
            for (int i = 0; i < arr.length; i++) {
                final int c = freq.merge(arr[i], 1, Integer::sum);
                TreeMap<Integer, Integer> idx = tms.get(arr[i]);
                if (idx == null) {
                    idx = new TreeMap<>();
                    idx.put(i, c);
                    tms.put(arr[i], idx);
                } else {
                    idx.put(i, c);
                }
            }
        }

        public int query(int left, int right, int value) {
            final TreeMap<Integer, Integer> idx = tms.get(value);
            if (idx == null) {
                return 0;
            }
            final Map.Entry<Integer, Integer> ll = idx.ceilingEntry(left);
            final Map.Entry<Integer, Integer> rr = idx.floorEntry(right);
            if (ll == null || rr == null || ll.getKey() > right || rr.getKey() < left) {
                return 0;
            }
            return rr.getValue() - ll.getValue() + 1;
        }
    }
}
