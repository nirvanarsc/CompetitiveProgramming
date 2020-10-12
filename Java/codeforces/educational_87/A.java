package codeforces.educational_87;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public final class A {

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int t = in.nextInt();
        for (int x = 0; x < t; x++) {
            final int a = in.nextInt();
            final long b = in.nextLong();
            final int c = in.nextInt();
            final int d = in.nextInt();
            if (b >= a) {
                System.out.println(b);
            } else {
                final long need = a - b;
                final double diff = c - d;
                if (c - d <= 0) {
                    System.out.println(-1);
                } else {
                    final long perSleep = (long) Math.ceil(need / diff);
                    System.out.println(b + perSleep * c);
                }
            }
        }
    }
}
