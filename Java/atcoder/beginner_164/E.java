package atcoder.beginner_164;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public final class E {

    static class Pair {
        int v, money;

        Pair(int v, int money) {
            this.v = v;
            this.money = money;
        }
    }

    static class Edge {
        int to, cost, dist;

        Edge(int to, int cost, int dist) {
            this.to = to;
            this.cost = cost;
            this.dist = dist;
        }
    }

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int n = in.nextInt();
        final int m = in.nextInt();
        final int s = in.nextInt();
        final List<List<Edge>> edges = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            edges.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            final int u = in.nextInt() - 1;
            final int v = in.nextInt() - 1;
            final int a = in.nextInt();
            final int b = in.nextInt();
            edges.get(u).add(new Edge(v, a, b));
            edges.get(v).add(new Edge(u, a, b));
        }
        final int[] c = new int[n];
        final long[] d = new long[n];
        for (int i = 0; i < n; i++) {
            c[i] = in.nextInt();
            d[i] = in.nextInt();
        }
        if (s >= 300) {
            final long[] t = new long[n];
            Arrays.fill(t, Long.MAX_VALUE);
            t[0] = 0;
            final PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.comparingLong(i -> t[i]));
            queue.add(0);
            while (!queue.isEmpty()) {
                final Integer p = queue.poll();
                for (Edge edge : edges.get(p)) {
                    if (t[edge.to] > t[p] + edge.dist) {
                        t[edge.to] = t[p] + edge.dist;
                        queue.add(edge.to);
                    }
                }
            }
            for (int i = 1; i < n; i++) {
                System.out.println(t[i]);
            }
            return;
        }
        final long[][] time = new long[n][300];
        for (long[] row : time) {
            Arrays.fill(row, Long.MAX_VALUE);
        }
        time[0][s] = 0;
        final PriorityQueue<Pair> queue = new PriorityQueue<>(
                Comparator.comparingLong(pair -> time[pair.v][pair.money]));
        queue.add(new Pair(0, s));
        while (!queue.isEmpty()) {
            final Pair pair = queue.poll();
            if (pair.money + c[pair.v] < 300) {
                update(pair.v, pair.money + c[pair.v], time[pair.v][pair.money] + d[pair.v], time, queue);
            }
            for (Edge edge : edges.get(pair.v)) {
                if (pair.money - edge.cost >= 0) {
                    update(edge.to, pair.money - edge.cost, time[pair.v][pair.money] + edge.dist, time, queue);
                }
            }
        }
        for (int i = 1; i < n; i++) {
            long ans = Long.MAX_VALUE;
            for (int j = 0; j < 300; j++) {
                ans = Math.min(ans, time[i][j]);
            }
            System.out.println(ans);
        }
    }

    private static void update(int v, int money, long t, long[][] time, PriorityQueue<Pair> queue) {
        if (time[v][money] > t) {
            time[v][money] = t;
            queue.add(new Pair(v, money));
        }
    }
}
