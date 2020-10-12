package leetcode.hard;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P_269 {

    static class Node {
        int inDegree;
        char c;

        Node(char c) {
            this.c = c;
        }
    }

    public String alienOrder(String[] words) {
        final Map<Character, Node> nodes = new HashMap<>();
        final Map<Node, List<Node>> g = new HashMap<>();
        for (String word : words) {
            for (char c : word.toCharArray()) {
                nodes.putIfAbsent(c, new Node(c));
            }
        }
        for (int i = 0; i < words.length - 1; i++) {
            if (words[i].length() > words[i + 1].length() && words[i].startsWith(words[i + 1])) {
                return "";
            }
            for (int j = 0; j < Math.min(words[i].length(), words[i + 1].length()); j++) {
                final char origin = words[i].charAt(j);
                final char down = words[i + 1].charAt(j);
                if (origin != down) {
                    g.computeIfAbsent(nodes.get(origin), v -> new ArrayList<>()).add(nodes.get(down));
                    nodes.get(down).inDegree++;
                    break;
                }
            }
        }
        final StringBuilder sb = new StringBuilder();
        final Deque<Node> q = new ArrayDeque<>();
        for (Node n : nodes.values()) {
            if (n.inDegree == 0) {
                q.offerLast(n);
            }
        }
        while (!q.isEmpty()) {
            final Node node = q.removeFirst();
            sb.append(node.c);
            for (Node n : g.getOrDefault(node, Collections.emptyList())) {
                if (--n.inDegree == 0) {
                    q.offerLast(n);
                }
            }
        }
        return sb.length() == nodes.size() ? sb.toString() : "";
    }
}
