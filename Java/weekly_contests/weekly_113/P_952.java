package weekly_contests.weekly_113;

import java.util.HashMap;
import java.util.Map;

import utils.DataStructures.UnionFind;

public class P_952 {

    @SuppressWarnings("MethodParameterNamingConvention")
    public int largestComponentSize(int[] A) {
        final int N = A.length;
        final Map<Integer, Integer> map = new HashMap<>();
        final UnionFind uf = new UnionFind(N);
        for (int i = 0; i < N; i++) {
            for (int j = 2; j * j <= A[i]; j++) {
                if (A[i] % j == 0) {
                    putIfAbsent(map, uf, i, j);
                    putIfAbsent(map, uf, i, A[i] / j);
                }
            }
            putIfAbsent(map, uf, i, A[i]);
        }
        int res = 0;
        for (int size : uf.size()) {
            res = Math.max(res, size);
        }
        return res;
    }

    private static void putIfAbsent(Map<Integer, Integer> map, UnionFind uf, int i, int j) {
        if (!map.containsKey(j)) {
            map.put(j, i);
        } else {
            uf.union(i, map.get(j));
        }
    }
}
