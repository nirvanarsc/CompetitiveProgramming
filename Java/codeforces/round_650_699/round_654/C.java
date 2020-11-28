package codeforces.round_650_699.round_654;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public final class C {

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int t = Integer.parseInt(in.nextLine());
        for (int x = 0; x < t; x++) {
            final long v = in.nextLong();
            final long c = in.nextLong();
            final long vG = in.nextLong();
            final long cG = in.nextLong();
            if (v + c < vG + cG || Math.min(v, c) < cG) {
                System.out.println("NO");
            } else {
                System.out.println("YES");
            }
        }
    }
}
