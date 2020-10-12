package codeforces.round_642;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public final class A {

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int t = in.nextInt();
        for (int x = 0; x < t; x++) {
            final int n = in.nextInt();
            final int m = in.nextInt();
            in.nextLine();
            if (n == 1) {
                System.out.println(0);
            } else if (n == 2) {
                System.out.println(m);
            } else {
                System.out.println(2 * m);
            }
        }
    }
}
