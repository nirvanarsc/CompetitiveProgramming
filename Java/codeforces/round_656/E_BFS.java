package codeforces.round_656;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public final class E_BFS {

    private static class Node {
        int inDegree;
        int idx;

        Node(int idx) {
            this.idx = idx;
        }
    }

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int t = Integer.parseInt(in.nextLine());
        for (int x = 0; x < t; x++) {
            final int n = in.nextInt();
            final int m = in.nextInt();
            in.nextLine();
            final Map<Node, Set<Node>> g = new HashMap<>();
            final Map<Integer, Node> nodes = new HashMap<>();
            final int[][] queries = new int[m][2];
            for (int i = 1; i <= n; i++) {
                nodes.putIfAbsent(i, new Node(i));
            }
            for (int i = 0; i < m; i++) {
                final String[] edge = in.nextLine().split(" ");
                final int type = Integer.parseInt(edge[0]);
                final int from = Integer.parseInt(edge[1]);
                final int to = Integer.parseInt(edge[2]);
                queries[i] = new int[] { from, to };
                if (type == 1) {
                    g.computeIfAbsent(nodes.get(from), v -> new HashSet<>()).add(nodes.get(to));
                    nodes.get(to).inDegree++;
                }
            }
            final Map<Integer, Integer> topSort = topSort(n, g, nodes.values());
            if (topSort.isEmpty()) {
                System.out.println("NO");
                continue;
            }
            System.out.println("YES");
            for (int[] edge : queries) {
                if (topSort.get(edge[0]) < topSort.get(edge[1])) {
                    System.out.println(edge[0] + " " + edge[1]);
                } else {
                    System.out.println(edge[1] + " " + edge[0]);
                }
            }
        }
    }

    private static Map<Integer, Integer> topSort(int n, Map<Node, Set<Node>> g, Collection<Node> nodes) {
        final Deque<Node> q = new ArrayDeque<>();
        for (Node next : nodes) {
            if (next.inDegree == 0) {
                q.offerLast(next);
            }
        }
        final Map<Integer, Integer> topSort = new HashMap<>();
        for (int i = 0; !q.isEmpty(); i++) {
            final Node node = q.removeFirst();
            topSort.put(node.idx, i);
            for (Node next : g.getOrDefault(node, Collections.emptySet())) {
                if (--next.inDegree == 0) {
                    q.offerLast(next);
                }
            }
        }
        return topSort.size() == n ? topSort : Collections.emptyMap();
    }
}
