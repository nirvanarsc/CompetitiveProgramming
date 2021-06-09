package binarysearch.weekly_32;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

@SuppressWarnings({ "InnerClassMayBeStatic", "unused", "PublicConstructorInNonPublicClass" })
public class P_3 {

    class RunLengthDecoder {

        private class SegTree {
            int leftMost, rightMost;
            SegTree left, right;
            int mask;

            SegTree(int leftMost, int rightMost, int[] arr) {
                this.leftMost = leftMost;
                this.rightMost = rightMost;
                if (leftMost == rightMost) {
                    mask = arr[leftMost];
                } else {
                    final int mid = leftMost + rightMost >>> 1;
                    left = new SegTree(leftMost, mid, arr);
                    right = new SegTree(mid + 1, rightMost, arr);
                    recalc();
                }
            }

            private void recalc() {
                if (leftMost == rightMost) {
                    return;
                }
                mask = left.mask | right.mask;
            }

            private int query(int l, int r) {
                if (r < leftMost || l > rightMost) {
                    return 0;
                }
                if (l <= leftMost && rightMost <= r) {
                    return mask;
                }
                return left.query(l, r) | right.query(l, r);
            }
        }

        TreeMap<Integer, Integer> normalized = new TreeMap<>();
        SegTree st;

        public RunLengthDecoder(String s) {
            int curr = 0;
            final int n = s.length();
            final List<Integer> list = new ArrayList<>();
            for (int i = 0, stIdx = 0; i < n; i++) {
                normalized.put(curr, stIdx++);
                int j = i;
                while (j < n && Character.isDigit(s.charAt(j))) {
                    j++;
                }
                list.add(1 << (s.charAt(j) - 'a' + 1));
                curr += Integer.parseInt(s.substring(i, j));
                i = j;
            }
            final int[] arr = list.stream().mapToInt(Integer::intValue).toArray();
            st = new SegTree(0, arr.length - 1, arr);
        }

        public String value(int i) {
            return valueInRange("a", i, i + 1);
        }

        public String valueInRange(String c, int i, int j) {
            final int l = normalized.floorEntry(i).getValue();
            final int r = normalized.floorEntry(j - 1).getValue();
            final int mask = st.query(l, r);
            for (int idx = c.charAt(0) - 'a' + 1; idx < 27; idx++) {
                if ((mask & (1 << idx)) != 0) {
                    return String.valueOf((char) (idx + 'a' - 1));
                }
            }
            return "?";
        }
    }
}
