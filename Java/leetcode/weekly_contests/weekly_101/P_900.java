package leetcode.weekly_contests.weekly_101;

@SuppressWarnings({ "InnerClassMayBeStatic", "unused", "MethodParameterNamingConvention" })
public class P_900 {

    class RLEIterator {
        int[][] store;
        int idx;

        RLEIterator(int[] A) {
            store = new int[A.length][2];
            for (int i = 0; i < A.length; i += 2) {
                store[i] = new int[] { A[i + 1], A[i] };
            }
        }

        public int next(int n) {
            int res = -1;
            while (n > 0 && idx < store.length) {
                final int take = Math.min(n, store[idx][1]);
                n -= take;
                store[idx][1] -= take;
                if (n == 0) {
                    res = store[idx][0];
                }
                if (store[idx][1] == 0) {
                    idx++;
                }
            }
            return res;
        }
    }
}
