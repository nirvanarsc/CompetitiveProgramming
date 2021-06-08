package binarysearch.weekly_32;

import java.util.TreeMap;

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
            final int[] arr = new int[n / 2];
            for (int i = 0; i < n; i += 2) {
                normalized.put(curr, i / 2);
                arr[i / 2] = 1 << (s.charAt(i + 1) - 'a' + 1);
                curr += s.charAt(i) - '0';
            }
            st = new SegTree(0, (n / 2) - 1, arr);
        }

        public String value(int i) {
            final int u = normalized.floorEntry(i).getValue();
            final int mask = st.query(u, u);
            for (int idx = 0; idx < 30; idx++) {
                if ((mask & (1 << idx)) != 0) {
                    return String.valueOf((char) (idx + 'a' - 1));
                }
            }
            return "?";
        }

        public String valueInRange(String c, int i, int j) {
            final int l = normalized.floorEntry(i).getValue();
            final int r = normalized.floorEntry(j - 1).getValue();
            final int mask = st.query(l, r);
            // System.out.println(mask + " " + l + " " + r);
            // for(int k=0; k< 2; k++) {
            //     System.out.println(st.query(k, k));
            // }
            for (int idx = c.charAt(0) - 'a' + 1; idx < 30; idx++) {
                if ((mask & (1 << idx)) != 0) {
                    return String.valueOf((char) (idx + 'a' - 1));
                }
            }
            return "?";
        }
    }

}
