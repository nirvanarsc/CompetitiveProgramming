package codeforces.round_650_699.round_660;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public final class A {

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int t = Integer.parseInt(in.nextLine());
        for (int x = 0; x < t; x++) {
            final int n = Integer.parseInt(in.nextLine());
            if (n <= 30) {
                System.out.println("NO");
            } else {
                System.out.println("YES");
                final int rem = n - 30;
                if (rem == 6 || rem == 10 || rem == 14) {
                    System.out.println("6 15 14 " + (n - 35));
                } else {
                    System.out.println("6 10 14 " + rem);
                }
            }
        }
    }
}
