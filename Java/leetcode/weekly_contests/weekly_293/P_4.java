package leetcode.weekly_contests.weekly_293;

import java.util.Comparator;
import java.util.TreeSet;

@SuppressWarnings({ "InnerClassMayBeStatic", "unused", "PublicConstructorInNonPublicClass" })
public class P_4 {

    class CountIntervals {

        TreeSet<int[]> ts;
        int res;

        public CountIntervals() {
            ts = new TreeSet<>(Comparator.comparingInt(a -> a[0]));
            res = 0;
        }

        public void add(int left, int right) {
            final int[] curr = { left, right };
            int[] ll = ts.floor(curr);
            while (ll != null && overlaps(curr, ll)) {
                ts.remove(ll);
                res -= ll[1] - ll[0] + 1;
                left = Math.min(left, ll[0]);
                right = Math.max(right, ll[1]);
                ll = ts.lower(ll);
            }
            int[] rr = ts.ceiling(curr);
            while (rr != null && overlaps(curr, rr)) {
                ts.remove(rr);
                res -= rr[1] - rr[0] + 1;
                left = Math.min(left, rr[0]);
                right = Math.max(right, rr[1]);
                rr = ts.higher(rr);
            }
            res += right - left + 1;
            ts.add(new int[] { left, right });
        }

        public int count() {
            return res;
        }

        private boolean overlaps(int[] left, int[] right) {
            return !(left[1] < right[0] || right[1] < left[0]);
        }
    }
}
