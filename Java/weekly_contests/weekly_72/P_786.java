package weekly_contests.weekly_72;

import java.util.PriorityQueue;

public class P_786 {

    @SuppressWarnings("MethodParameterNamingConvention")
    public int[] kthSmallestPrimeFraction(int[] A, int K) {
        final int n = A.length;
        final PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(A[o1[0]] * A[o2[1]],
                                                                                        A[o2[0]] * A[o1[1]]));
        for (int i = 0; i < n - 1; i++) {
            pq.add(new int[] { i, n - 1 });
        }
        while(K-- > 1) {
            final int[] pop = pq.remove();
            if (pop[1] - 1 > pop[0]) {
                pop[1]--;
                pq.add(pop);
            }
        }
        return new int[] { A[pq.element()[0]], A[pq.element()[1]] };
    }
}
