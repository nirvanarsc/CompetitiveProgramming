package atcoder.grand_44;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;

public final class A {

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            final long n = in.nextLong();
            final int a = in.nextInt();
            final int b = in.nextInt();
            final int c = in.nextInt();
            final int d = in.nextInt();
            in.nextLine();
            System.out.println(dfs(n, a, b, c, d));
        }
    }

    private static long dfs(long n, int a, int b, int c, int d) {
        final Set<Long> seen = new HashSet<>();
        final PriorityQueue<long[]> q = new PriorityQueue<>(Comparator.comparingLong(l -> l[1]));
        q.offer(new long[] { n, 0 });
        while (!q.isEmpty()) {
            final long[] curr = q.remove();
            if (curr[0] == 0) {
                return curr[1];
            }
            if (!seen.add(curr[0])) {
                continue;
            }
            q.offer(new long[] { curr[0] / 5, curr[1] + c + (d * (curr[0] % 5)) });
            q.offer(new long[] { (curr[0] / 5) + 1, curr[1] + c + (d * (5 - (curr[0] % 5))) });
            q.offer(new long[] { curr[0] / 3, curr[1] + b + (d * (curr[0] % 3)) });
            q.offer(new long[] { (curr[0] / 3) + 1, curr[1] + b + (d * (3 - (curr[0] % 3))) });
            q.offer(new long[] { curr[0] / 2, curr[1] + a + (d * (curr[0] % 2)) });
            q.offer(new long[] { (curr[0] / 2) + 1, curr[1] + a + (d * (2 - (curr[0] % 2))) });
            if (curr[0] <= Math.floorDiv(Long.MAX_VALUE, d) && curr[1] + curr[0] * d > 0) {
                q.offer(new long[] { 0, curr[1] + curr[0] * d });
            }
        }
        return -1;
    }
}
