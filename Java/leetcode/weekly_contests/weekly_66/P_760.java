package leetcode.weekly_contests.weekly_66;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class P_760 {

    @SuppressWarnings("MethodParameterNamingConvention")
    public int[] anagramMappings(int[] A, int[] B) {
        final Map<Integer, Deque<Integer>> map = new HashMap<>();
        for (int i = 0; i < B.length; i++) {
            map.computeIfAbsent(B[i], v -> new ArrayDeque<>()).addFirst(i);
        }
        final int[] res = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            res[i] = map.get(A[i]).removeFirst();
        }
        return res;
    }
}
