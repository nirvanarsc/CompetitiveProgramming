package codeforces.round_644;

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
            final int min = Math.min(a, b) * 2;
            final int max = Math.max(min, Math.max(a, b));
            System.out.println(max * max);
        }
    }
}
