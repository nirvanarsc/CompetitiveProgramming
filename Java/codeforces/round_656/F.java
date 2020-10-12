package codeforces.round_656;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;

public final class F {

    private static class Node {
        int degree;
    }

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int t = Integer.parseInt(in.nextLine());
        for (int x = 0; x < t; x++) {
            final int n = in.nextInt();
            final int k = in.nextInt();
            in.nextLine();
            final Map<Node, Set<Node>> g = new HashMap<>();
            final Map<Integer, Node> nodes = new HashMap<>();
            for (int i = 0; i < n; i++) {
                final int from = in.nextInt();
                final int to = in.nextInt();
                in.nextLine();
                nodes.putIfAbsent(from, new Node());
                nodes.putIfAbsent(to, new Node());
                g.computeIfAbsent(nodes.get(from), v -> new HashSet<>()).add(nodes.get(to));
                g.computeIfAbsent(nodes.get(to), v -> new HashSet<>()).add(nodes.get(from));
                nodes.get(to).degree++;
                nodes.get(from).degree++;
            }
            final PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.degree));
            for (Node node : g.keySet()) {
                if (node.degree != 1) {
                    pq.offer(node);
                }
            }
            int res;
            for (res = 0; !pq.isEmpty(); res++) {
                int level = k;
                final Node curr = pq.remove();
                for (Node next : new HashSet<>(g.getOrDefault(curr, Collections.emptySet()))) {
                    if (next.degree == 1) {
                        if (level == 0) {
                            break;
                        } else {
                            level--;
                            g.get(curr).remove(next);
                            curr.degree--;
                        }
                    }
                }
            }
        }
    }
}
