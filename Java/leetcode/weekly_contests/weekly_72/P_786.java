package leetcode.weekly_contests.weekly_72;

import java.util.PriorityQueue;

@SuppressWarnings("MethodParameterNamingConvention")
public class P_786 {

    public int[] kthSmallestPrimeFractionPQ(int[] A, int K) {
        final int n = A.length;
        final PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(A[o1[0]] * A[o2[1]],
                                                                                        A[o2[0]] * A[o1[1]]));
        for (int i = 0; i < n - 1; i++) {
            pq.add(new int[] { i, n - 1 });
        }
        while (K-- > 1) {
            final int[] pop = pq.remove();
            if (pop[1] - 1 > pop[0]) {
                pop[1]--;
                pq.add(pop);
            }
        }
        return new int[] { A[pq.element()[0]], A[pq.element()[1]] };
    }

    public int[] kthSmallestPrimeFraction(int[] A, int K) {
        double lo = 0, hi = 1.0;
        while (lo < hi) {
            final double mid = (lo + hi) * 0.5;
            double max_f = 0.0;
            int count = 0;
            int j = 1, p = 0, q = 0;
            for (int i = 0; i < A.length - 1; i++) {
                while (j < A.length && A[i] > mid * A[j]) {
                    j++;
                }
                count += A.length - j;
                if (j == A.length) {
                    break;
                }
                final double f = (double) A[i] / A[j];
                if (f > max_f) {
                    p = i;
                    q = j;
                    max_f = f;
                }
            }
            if (count > K) {
                hi = mid;
            } else if (count < K) {
                lo = mid;
            } else {
                return new int[] { A[p], A[q] };
            }
        }
        return new int[] { -1, -1 };
    }
}
