package hard;

import java.util.TreeMap;

@SuppressWarnings("unused")
public class P_352 {

    static class SummaryRanges {

        TreeMap<Integer, int[]> bst;

        SummaryRanges() {
            bst = new TreeMap<>();
        }

        public void addNum(int val) {
            if (bst.containsKey(val)) {
                return;
            }
            final Integer l = bst.lowerKey(val);
            final Integer h = bst.higherKey(val);
            if (l != null && h != null && bst.get(l)[1] + 1 == val && h == val + 1) {
                bst.get(l)[1] = bst.get(h)[1];
                bst.remove(h);
            } else if (l != null && bst.get(l)[1] + 1 >= val) {
                bst.get(l)[1] = Math.max(bst.get(l)[1], val);
            } else if (h != null && h == val + 1) {
                bst.put(val, new int[] { val, bst.get(h)[1] });
                bst.remove(h);
            } else {
                bst.put(val, new int[] { val, val });
            }
        }

        public int[][] getIntervals() {
            return bst.values().toArray(int[][]::new);
        }
    }
}
