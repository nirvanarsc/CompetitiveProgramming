package codeforces.round_647;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public final class C {

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int t = Integer.parseInt(in.nextLine());
        for (int x = 0; x < t; x++) {
            System.out.println(f(Long.parseLong(in.nextLine())));
        }
    }

    private static long f(long n) {
        if (n == 0) { return 0; }
        return n + f(n / 2);
    }
}
