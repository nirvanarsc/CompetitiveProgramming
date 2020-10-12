package codeforces.round_642;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

@SuppressWarnings("SubtractionInCompareTo")
public final class D {

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int t = in.nextInt();
        for (int x = 0; x < t; x++) {
            final int n = in.nextInt();
            final int[] res = new int[n];
            final Comparator<int[]> comparator = (a, b) -> a[1] - a[0] == b[1] - b[0]
                                                           ? Integer.compare(a[0], b[0])
                                                           : Integer.compare(b[1] - b[0], a[1] - a[0]);
            final PriorityQueue<int[]> pq = new PriorityQueue<>(comparator);
            pq.offer(new int[] { 0, n - 1 });
            for (int i = 1; !pq.isEmpty(); i++) {
                final int[] next = pq.remove();
                final int mid = next[0] + next[1] >>> 1;
                res[mid] = i;
                if (next[0] != next[1]) {
                    if (next[0] <= mid - 1) { pq.add(new int[] { next[0], mid - 1 }); }
                    if (mid + 1 <= next[1]) { pq.add(new int[] { mid + 1, next[1] }); }
                }
            }
            for (int i = 0; i < n; i++) {
                System.out.print(res[i] + " ");
            }
            System.out.println();
        }
    }
}
