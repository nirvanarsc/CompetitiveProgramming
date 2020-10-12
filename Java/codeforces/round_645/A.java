package codeforces.round_645;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public final class A {

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int t = in.nextInt();
        for (int x = 0; x < t; x++) {
            final int a = in.nextInt();
            final int b = in.nextInt();
            in.nextLine();
            if (b % 2 != 0) {
                System.out.println((int) Math.ceil(a * 0.5) + (b - 1) / 2 * a);
            } else {
                System.out.println((b / 2) * a);
            }
        }
    }
}
