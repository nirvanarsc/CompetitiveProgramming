package codeforces.round_650_699.round_656;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.TreeMap;

public final class A {

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int t = Integer.parseInt(in.nextLine());
        for (int x = 0; x < t; x++) {
            final TreeMap<Integer, Integer> ts = new TreeMap<>();
            final int x1 = in.nextInt();
            final int y1 = in.nextInt();
            final int z1 = in.nextInt();
            in.nextLine();
            ts.merge(x1, 1, Integer::sum);
            ts.merge(y1, 1, Integer::sum);
            ts.merge(z1, 1, Integer::sum);
            final Integer last = ts.lastEntry().getKey();
            final Integer first = ts.firstEntry().getKey();
            if (ts.size() == 3) {
                System.out.println("NO");
            } else {
                if (ts.size() == 2) {
                    if (ts.get(ts.lastKey()) == 1) {
                        System.out.println("NO");
                    } else {
                        System.out.println("YES");
                        System.out.println(first + " " + first + ' ' + last);
                    }
                } else {
                    System.out.println("YES");
                    System.out.println(last + " " + last + ' ' + last);
                }
            }
        }
    }
}
