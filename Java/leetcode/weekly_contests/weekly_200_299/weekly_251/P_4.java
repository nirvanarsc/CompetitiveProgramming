package leetcode.weekly_contests.weekly_200_299.weekly_251;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P_4 {

    static class Node {
        String name;
        Map<String, Node> next = new HashMap<>();
        boolean del;

        Node(String name) {
            this.name = name;
        }
    }

    private static void addPath(Node node, List<String> path) {
        for (String s : path) {
            if (!node.next.containsKey(s)) {
                node.next.put(s, new Node(s));
            }
            node = node.next.get(s);
        }
    }

    private static String dedupe(Node node) {
        final StringBuilder subfolder = new StringBuilder();
        for (Node v : node.next.values()) {
            subfolder.append('+').append(dedupe(v));
        }
        final String path = subfolder.toString();
        if (!path.isEmpty()) {
            if (seen.containsKey(path)) {
                seen.get(path).del = node.del = true;
            } else {
                seen.put(path, node);
            }
        }
        return node.name + path;
    }

    private static void dfs(Node node) {
        if (node.del) {
            return;
        }
        p.add(node.name);
        res.add(new ArrayList<>(p));
        for (Node v : node.next.values()) {
            dfs(v);
        }
        p.remove(p.size() - 1);
    }

    static Map<String, Node> seen;
    static List<List<String>> res;
    static List<String> p;

    public List<List<String>> deleteDuplicateFolder(List<List<String>> paths) {
        seen = new HashMap<>();
        res = new ArrayList<>();
        p = new ArrayList<>();
        final Node root = new Node("/");
        for (List<String> pp : paths) {
            addPath(root, pp);
        }
        dedupe(root);
        for (Node v : root.next.values()) {
            dfs(v);
        }
        return res;
    }
}
