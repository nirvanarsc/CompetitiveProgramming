package codeforces.round_660;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public final class D {

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int n = Integer.parseInt(in.nextLine());
        final long[] a = new long[n];
        final int[] b = new int[n];
        final Map<Integer, List<Integer>> g = new HashMap<>();
        for (int i = 0; i < n; i++) {
            g.put(i, new ArrayList<>());
            a[i] = in.nextLong();
        }
        in.nextLine();
        for (int i = 0; i < n; i++) {
            b[i] = in.nextInt();
            if (b[i] != -1) {
                b[i]--;
            }
        }
        in.nextLine();
        final int[] inDegrees = new int[n];
        for (int i = 0; i < n; i++) {
            if (b[i] == -1) { continue; }
            if (a[i] <= 0) {
                g.get(b[i]).add(i);
                inDegrees[i]++;
            } else {
                g.get(i).add(b[i]);
                inDegrees[b[i]]++;
            }
        }
        final Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (inDegrees[i] == 0) {
                q.offerLast(i);
            }
        }
        long res = 0;
        final int[] topSort = new int[n];
        for (int i = 0; !q.isEmpty(); i++) {
            final Integer curr = q.removeFirst();
            topSort[i] = curr + 1;
            if (b[curr] != -1) {
                a[b[curr]] += a[curr];
            }
            for (int next : g.getOrDefault(curr, Collections.emptyList())) {
                if (--inDegrees[next] == 0) {
                    q.offerLast(next);
                }
            }
        }
        for (int idx : topSort) {
            res += a[idx - 1];
        }
        System.out.println(res);
        for (int idx : topSort) {
            System.out.print(idx + " ");
        }
        System.out.println();
    }
}
