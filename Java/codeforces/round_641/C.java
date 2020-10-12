package codeforces.round_641;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class C {

    public static long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    private static long lcm(long a, long b) {
        return (a * b) / gcd(a, b);
    }

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int n = in.nextInt();
        final int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        final long[] gcd = new long[n];
        gcd[n - 1] = a[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            gcd[i] = gcd(gcd[i + 1], a[i]);
        }
        final List<Long> gcds = new ArrayList<>();
        for (int i = 0; i < n - 1; i++) {
            gcds.add(lcm(a[i], gcd[i + 1]));
        }
        if (gcds.isEmpty()) {
            System.out.println(1);
            return;
        }
        long ans = gcds.get(0);
        for (int i = 1; i < gcds.size(); i++) {
            ans = gcd(ans, gcds.get(i));
        }
        System.out.println(ans);
    }
}
