package codeforces.round_600_649.round_643;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public final class A {

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int t = in.nextInt();
        for (int x = 0; x < t; x++) {
            long a = in.nextLong();
            final long k = in.nextLong();
            in.nextLine();
            for (int i = 1; i < k; i++) {
                long cp = a;
                long min = 10;
                long max = 0;
                while (cp > 0) {
                    min = Math.min(min, cp % 10);
                    max = Math.max(max, cp % 10);
                    cp /= 10;
                }
                if (min == 0) {
                    break;
                }
                a += min * max;
            }
            System.out.println(a);
        }
    }
}
