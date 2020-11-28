package codeforces.round_600_649.round_647;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public final class A {

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int t = in.nextInt();
        for (int x = 0; x < t; x++) {
            final long a = in.nextLong();
            final long b = in.nextLong();
            in.nextLine();
            if (a > b) {
                calc(a, b);
            } else {
                calc(b, a);
            }
        }
    }

    private static void calc(long a, long b) {
        if (a % b != 0) {
            System.out.println(-1);
            return;
        }
        long n = a / b;
        if ((n & (n - 1)) != 0) {
            System.out.println(-1);
            return;
        }
        int res = 0;
        while (n % 8 == 0) {
            res++;
            n /= 8;
        }
        while (n % 4 == 0) {
            res++;
            n /= 4;
        }
        while (n % 2 == 0) {
            res++;
            n /= 2;
        }
        System.out.println(res);
    }
}
