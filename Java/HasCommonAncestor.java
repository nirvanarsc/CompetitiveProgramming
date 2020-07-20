import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class HasCommonAncestor {

    public static void main(String[] args) {
        final int[][] parentChildPairs1 = {
                { 1, 3 }, { 2, 3 }, { 3, 6 }, { 5, 6 }, { 5, 7 }, { 4, 5 },
                { 4, 8 }, { 4, 9 }, { 9, 11 }, { 14, 4 }, { 13, 12 }, { 12, 9 }
        };
        System.out.println(hasCommonAncestor(parentChildPairs1, 3, 8));
        System.out.println(hasCommonAncestor(parentChildPairs1, 5, 8));
        System.out.println(hasCommonAncestor(parentChildPairs1, 6, 8));
        System.out.println(hasCommonAncestor(parentChildPairs1, 6, 9));
        System.out.println(hasCommonAncestor(parentChildPairs1, 1, 3));
        System.out.println(hasCommonAncestor(parentChildPairs1, 3, 1));
        System.out.println(hasCommonAncestor(parentChildPairs1, 7, 11));
        System.out.println(hasCommonAncestor(parentChildPairs1, 6, 5));
        System.out.println(hasCommonAncestor(parentChildPairs1, 5, 6));
    }

    public static boolean hasCommonAncestor(int[][] parentChildPairs, int a, int b) {
        // DAG from child to parent
        final Map<Integer, List<Integer>> g = new HashMap<>();
        for (int[] p : parentChildPairs) {
            g.computeIfAbsent(p[1], v -> new ArrayList<>()).add(p[0]);
        }
        final Map<Integer, Integer> visitedCount = new HashMap<>();
        dfs(g, a, visitedCount, new HashSet<>());
        dfs(g, b, visitedCount, new HashSet<>());
        for (Map.Entry<Integer, Integer> e : visitedCount.entrySet()) {
            if (e.getValue() == 2 && e.getKey() != a && e.getKey() != b) {
                return true;
            }
        }
        return false;
    }

    private static void dfs(Map<Integer, List<Integer>> g, int curr, Map<Integer, Integer> count,
                            Set<Integer> seen) {
        if (seen.contains(curr)) {
            return;
        }
        seen.add(curr);
        count.merge(curr, 1, Integer::sum);
        for (int next : g.getOrDefault(curr, Collections.emptyList())) {
            dfs(g, next, count, seen);
        }
    }

    private HasCommonAncestor() {}
}
