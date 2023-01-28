package leetcode.hard;

import java.util.TreeMap;

@SuppressWarnings({ "unused", "InnerClassMayBeStatic", "PublicConstructorInNonPublicClass" })
public class P_352 {

    class SummaryRanges {

        TreeMap<Integer, int[]> tm;

        public SummaryRanges() {
            tm = new TreeMap<>();
        }

        public void addNum(int val) {
            if (tm.containsKey(val)) {
                return;
            }
            final Integer l = tm.lowerKey(val);
            final Integer h = tm.higherKey(val);
            if (l != null && h != null && tm.get(l)[1] + 1 == val && h == val + 1) {
                tm.get(l)[1] = tm.get(h)[1];
                tm.remove(h);
            } else if (l != null && tm.get(l)[1] + 1 >= val) {
                tm.get(l)[1] = Math.max(tm.get(l)[1], val);
            } else if (h != null && h == val + 1) {
                tm.put(val, new int[] { val, tm.get(h)[1] });
                tm.remove(h);
            } else {
                tm.put(val, new int[] { val, val });
            }
        }

        public int[][] getIntervals() {
            return tm.values().toArray(int[][]::new);
        }
    }
}
