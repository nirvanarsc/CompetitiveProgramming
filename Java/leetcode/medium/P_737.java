package leetcode.medium;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import utils.DataStructures.UnionFind;

public class P_737 {

    public boolean areSentencesSimilarTwo(String[] words1, String[] words2, List<List<String>> pairs) {
        if (words1.length != words2.length) {
            return false;
        }
        final Map<String, Set<String>> graph = new HashMap<>();
        for (List<String> s : pairs) {
            graph.computeIfAbsent(s.get(0), v -> new HashSet<>()).add(s.get(1));
            graph.computeIfAbsent(s.get(1), v -> new HashSet<>()).add(s.get(0));
        }
        for (int i = 0; i < words1.length; i++) {
            if (!words1[i].equals(words2[i])) {
                if (!bfs(words1[i], words2[i], graph)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean bfs(String word1, String word2, Map<String, Set<String>> graph) {
        final Deque<String> q = new ArrayDeque<>(graph.getOrDefault(word1, Collections.emptySet()));
        final Set<String> visited = new HashSet<>();
        while (!q.isEmpty()) {
            final String curr = q.removeFirst();
            visited.add(curr);
            if (curr.equals(word2)) {
                return true;
            }
            for (String neighbour : graph.getOrDefault(curr, Collections.emptySet())) {
                if (!visited.contains(neighbour)) {
                    q.offerLast(neighbour);
                }
            }
        }
        return false;
    }

    public boolean areSentencesSimilarTwoDFS(String[] words1, String[] words2, List<List<String>> pairs) {
        if (words1.length != words2.length) {
            return false;
        }
        final Map<String, Set<String>> graph = new HashMap<>();
        for (List<String> s : pairs) {
            graph.computeIfAbsent(s.get(0), v -> new HashSet<>()).add(s.get(1));
            graph.computeIfAbsent(s.get(1), v -> new HashSet<>()).add(s.get(0));
        }
        for (int i = 0; i < words1.length; i++) {
            if (!words1[i].equals(words2[i])) {
                if (!dfs(words1[i], words2[i], graph, new HashSet<>())) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean dfs(String curr, String target, Map<String, Set<String>> g, Set<String> visited) {
        if (visited.contains(curr)) {
            return false;
        }
        if (curr.equals(target)) {
            return true;
        }
        visited.add(curr);
        for (String neighbour : g.getOrDefault(curr, Collections.emptySet())) {
            if (dfs(neighbour, target, g, visited)) {
                return true;
            }
        }
        return false;
    }

    public boolean areSentencesSimilarTwoUF(String[] words1, String[] words2, List<List<String>> pairs) {
        if (words1.length != words2.length) {
            return false;
        }
        final UnionFind uf = new UnionFind(2 * pairs.size());
        final Map<String, Integer> index = new HashMap<>();
        int idx = 0;
        for (List<String> pair : pairs) {
            index.putIfAbsent(pair.get(0), idx++);
            index.putIfAbsent(pair.get(1), idx++);
            uf.union(index.get(pair.get(0)), index.get(pair.get(1)));
        }
        for (int i = 0; i < words1.length; i++) {
            if (!words1[i].equals(words2[i])) {
                if (!index.containsKey(words1[i]) || !index.containsKey(words2[i])) {
                    return false;
                }
                if (uf.find(index.get(words1[i])) != uf.find(index.get(words2[i]))) {
                    return false;
                }
            }
        }
        return true;
    }
}
