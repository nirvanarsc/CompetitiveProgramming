package codeforces.educational_85;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

public final class C {

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int t = in.nextInt();
        for (int x = 0; x < t; x++) {
            final int n = in.nextInt();
            final PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(v -> v[0]));
            final Map<Integer, long[]> map = new HashMap<>();
            for (int i = 1; i <= n; i++) {
                final long health = in.nextLong();
                final long damage = in.nextLong();
                final long[] e = { health, damage, i };
                pq.offer(e);
                map.put(i - 1, e);
                in.nextLine();
            }
            long res = 0;
            while (!pq.isEmpty()) {
                final long[] remove = pq.remove();
                if (remove[0] > 0) {
                    res += remove[0];
                    long boom = remove[1];
                    for (int j = (int) remove[2]; j <= remove[2] + n && boom > 0; j++) {
                        final long[] ints = map.get(j % n);
                        ints[0] -= boom;
                        if (ints[0] <= 0) {
                            boom = ints[1];
                        } else {
                            boom = 0;
                        }
                        map.put(j % n, ints);
                    }
                }
            }
            System.out.println(res);
        }
    }
}
