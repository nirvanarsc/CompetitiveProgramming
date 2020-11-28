package codeforces.round_650_699.round_665;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public final class B {

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int t = Integer.parseInt(in.nextLine());
        for (int x = 0; x < t; x++) {
            final String[] line = in.nextLine().split(" ");
            final String[] line2 = in.nextLine().split(" ");
            final int a0 = Integer.parseInt(line[0]);
            final int a2 = Integer.parseInt(line[2]);
            final int b1 = Integer.parseInt(line2[1]);
            final int b2 = Integer.parseInt(line2[2]);
            long res = 0;
            final int maxMatch = Math.min(a2, b1);
            res += 2L * maxMatch;
            if (a2 == maxMatch) {
                res -= 2L * Math.max(0, b2 - a0);
            } else {
                res -= 2L * Math.max(0, b2 - (a0 + a2 - maxMatch));
            }
            System.out.println(res);
        }
    }
}
