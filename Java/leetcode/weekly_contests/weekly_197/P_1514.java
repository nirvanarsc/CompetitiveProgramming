package leetcode.weekly_contests.weekly_197;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class P_1514 {

    static class Point {
        int end;
        double prob;

        Point(int end, double prob) {
            this.end = end;
            this.prob = prob;
        }
    }

    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        final boolean[] visited = new boolean[n];
        final PriorityQueue<Point> pq = new PriorityQueue<>((a, b) -> Double.compare(b.prob, a.prob));
        final Map<Integer, List<Point>> g = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            g.computeIfAbsent(edges[i][0], v -> new ArrayList<>()).add(new Point(edges[i][1], succProb[i]));
            g.computeIfAbsent(edges[i][1], v -> new ArrayList<>()).add(new Point(edges[i][0], succProb[i]));
        }
        pq.offer(new Point(start, 1.0));
        while (!pq.isEmpty()) {
            final Point curr = pq.remove();
            if (curr.end == end) {
                return curr.prob;
            }
            if (visited[curr.end]) {
                continue;
            }
            visited[curr.end] = true;
            for (Point next : g.getOrDefault(curr.end, Collections.emptyList())) {
                pq.offer(new Point(next.end, curr.prob * next.prob));
            }
        }
        return 0;
    }

    public double maxProbabilityBFS(int n, int[][] edges, double[] succProb, int start, int end) {
        final double[] probs = new double[n];
        final Deque<Point> q = new ArrayDeque<>();
        final Map<Integer, List<Point>> g = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            g.computeIfAbsent(edges[i][0], v -> new ArrayList<>()).add(new Point(edges[i][1], succProb[i]));
            g.computeIfAbsent(edges[i][1], v -> new ArrayList<>()).add(new Point(edges[i][0], succProb[i]));
        }
        q.offer(new Point(start, 1.0));
        while (!q.isEmpty()) {
            final Point curr = q.remove();
            for (Point next : g.getOrDefault(curr.end, Collections.emptyList())) {
                if (probs[next.end] >= curr.prob * next.prob) { continue; }
                q.offer(new Point(next.end, curr.prob * next.prob));
                probs[next.end] = curr.prob * next.prob;
            }
        }
        return probs[end];
    }
}
