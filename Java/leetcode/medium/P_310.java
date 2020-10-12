package leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P_310 {

    private static class Node {
        int inDegree;
        List<Node> adjacent = new ArrayList<>();
    }

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        final Map<Integer, Node> nodes = new HashMap<>();
        for (int i = 0; i < n; i++) {
            nodes.put(i, new Node());
        }

        for (int[] edge : edges) {
            final Node node = nodes.get(edge[0]);
            node.inDegree++;
            node.adjacent.add(nodes.get(edge[1]));
            nodes.get(edge[1]).adjacent.add(node);
            nodes.get(edge[1]).inDegree++;
        }

        while (nodes.size() > 2) {
            final List<Map.Entry<Integer, Node>> currLevel = new ArrayList<>();
            for (Map.Entry<Integer, Node> e : nodes.entrySet()) {
                if (e.getValue().inDegree == 1) {
                    currLevel.add(e);
                }
            }
            for (Map.Entry<Integer, Node> e : currLevel) {
                for (Node neighbour : e.getValue().adjacent) {
                    neighbour.inDegree--;
                }
                nodes.remove(e.getKey());
            }
        }

        return new ArrayList<>(nodes.keySet());
    }
}
