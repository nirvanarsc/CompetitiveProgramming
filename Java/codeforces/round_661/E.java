package codeforces.round_661;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

public final class E {

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int t = Integer.parseInt(in.nextLine());
        for (int x = 0; x < t; x++) {
            String[] line = in.nextLine().split(" ");
            final int n = Integer.parseInt(line[0]);
            final long s = Long.parseLong(line[1]);
            final Map<Integer, List<int[]>> g = new HashMap<>();
            final int[] weights = new int[n - 1];
            final int[] count = new int[n - 1];
            for (int i = 0; i < n - 1; i++) {
                line = in.nextLine().split(" ");
                final int u = Integer.parseInt(line[0]);
                final int v = Integer.parseInt(line[1]);
                final int w = Integer.parseInt(line[2]);
                weights[i] = w;
                g.computeIfAbsent(u, list -> new ArrayList<>()).add(new int[] { v, i });
                g.computeIfAbsent(v, list -> new ArrayList<>()).add(new int[] { u, i });
            }
            dfs(1, -1, count, g);
            final PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Long.compare(f(b), f(a)));
            long currSum = 0;
            for (int i = 0; i < n - 1; i++) {
                pq.offer(new int[] { weights[i], count[i] });
                currSum += (long) weights[i] * count[i];
            }
            int res = 0;
            while (currSum > s) {
                final int[] curr = pq.remove();
                currSum -= f(curr);
                pq.offer(new int[] { curr[0] / 2, curr[1] });
                res++;
            }
            System.out.println(res);
        }
    }

    private static long f(int[] a) {
        return (long) (a[0] - a[0] / 2) * a[1];
    }

    private static void dfs(int curr, int parent, int[] count, Map<Integer, List<int[]>> g) {
        if (g.getOrDefault(curr, Collections.emptyList()).size() == 1) {
            if (parent != -1) {
                count[parent] = 1;
            }
        }
        for (int[] next : g.getOrDefault(curr, Collections.emptyList())) {
            if (next[1] == parent) { continue; }
            dfs(next[0], next[1], count, g);
            if (parent != -1) {
                count[parent] += count[next[1]];
            }
        }
    }
}
