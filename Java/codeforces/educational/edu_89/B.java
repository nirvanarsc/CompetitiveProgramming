package codeforces.educational.edu_89;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Scanner;
import java.util.TreeSet;

public final class B {

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int t = in.nextInt();
        for (int test = 0; test < t; test++) {
            final int n = in.nextInt();
            final int x = in.nextInt();
            final int m = in.nextInt();
            final TreeSet<Integer> ts = new TreeSet<>(Collections.singleton(x));
            in.nextLine();
            for (int i = 0; i < m; i++) {
                final int l = in.nextInt();
                final int r = in.nextInt();
                in.nextLine();
                final int currMin = ts.first();
                final int currMax = ts.last();
                if ((l <= currMin && currMin <= r) || (l <= currMax && currMax <= r)) {
                    ts.add(l);
                    ts.add(r);
                }
            }
            System.out.println(ts.last() - ts.first() + 1);
        }
    }
}
