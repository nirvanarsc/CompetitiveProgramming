package weekly_contests.weekly_93;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.PriorityQueue;

public class P_870 {

    @SuppressWarnings("MethodParameterNamingConvention")
    public int[] advantageCount(int[] A, int[] B) {
        final PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));
        final Deque<Integer> deque = new ArrayDeque<>();
        Arrays.sort(A);
        for (int num : A) {
            deque.addFirst(num);
        }
        for (int i = 0; i < B.length; i++) {
            pq.add(new int[] { B[i], i });
        }
        while (!pq.isEmpty()) {
            final int[] curr = pq.remove();
            A[curr[1]] = deque.element() > curr[0] ? deque.removeFirst() : deque.removeLast();
        }
        return A;
    }
}
