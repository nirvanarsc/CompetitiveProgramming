package leetcode.weekly_contests.smarking_2;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P_444 {

    static class Node {
        List<Node> neighbours = new ArrayList<>();
        int inDegree;
        int val;

        Node(int val) {
            this.val = val;
        }
    }

    public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
        final Map<Integer, Node> map = new HashMap<>();
        for (List<Integer> l : seqs) {
            for (int i = 0; i < l.size(); i++) {
                map.putIfAbsent(l.get(i), new Node(l.get(i)));
                if (i < l.size() - 1) {
                    map.putIfAbsent(l.get(i + 1), new Node(l.get(i + 1)));
                    final Node node = map.get(l.get(i));
                    final Node next = map.get(l.get(i + 1));
                    next.inDegree++;
                    node.neighbours.add(next);
                }
            }
        }
        if (map.size() > org.length) {
            return false;
        }
        final Deque<Node> dq = new ArrayDeque<>();
        for (Node n : map.values()) {
            if (n.inDegree == 0) {
                dq.addFirst(n);
            }
        }
        int i = 0;
        while (!dq.isEmpty()) {
            if (dq.size() > 1 || org[i++] != dq.getFirst().val) {
                return false;
            }
            final Node curr = dq.removeFirst();
            for (Node n : curr.neighbours) {
                if (--n.inDegree == 0) {
                    dq.addFirst(n);
                }
            }
        }
        return i == org.length;
    }
}
