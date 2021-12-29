package leetcode.biweekly_contests.biweekly_68;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class P_2 {

    static Set<String> have;
    static Map<String, List<String>> g;
    static Map<String, Integer> inDegree;

    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        have = new HashSet<>(Arrays.asList(supplies));
        g = new HashMap<>();
        inDegree = new HashMap<>();
        final int n = recipes.length;
        for (String recipe : recipes) {
            inDegree.put(recipe, 0);
        }
        for (int i = 0; i < n; i++) {
            final String u = recipes[i];
            for (String v : ingredients.get(i)) {
                if (!have.contains(v)) {
                    g.computeIfAbsent(v, val -> new ArrayList<>()).add(u);
                    inDegree.merge(u, 1, Integer::sum);
                }
            }
        }
        final List<String> res = new ArrayList<>();
        final Deque<String> dq = new ArrayDeque<>();
        for (Map.Entry<String, Integer> e : inDegree.entrySet()) {
            if (e.getValue() == 0) {
                dq.offerLast(e.getKey());
            }
        }
        while (!dq.isEmpty()) {
            final String u = dq.removeFirst();
            res.add(u);
            for (String v : g.getOrDefault(u, Collections.emptyList())) {
                if (inDegree.merge(v, -1, Integer::sum) == 0) {
                    dq.offerLast(v);
                }
            }
        }
        return res;
    }
}
