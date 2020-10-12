package codeforces.round_661;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public final class B {

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int t = Integer.parseInt(in.nextLine());
        for (int x = 0; x < t; x++) {
            final int n = Integer.parseInt(in.nextLine());
            final int[] a = new int[n];
            final int[] b = new int[n];
            int minA = Integer.MAX_VALUE;
            int minB = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                a[i] = in.nextInt();
                minA = Math.min(minA, a[i]);
            }
            in.nextLine();
            for (int i = 0; i < n; i++) {
                b[i] = in.nextInt();
                minB = Math.min(minB, b[i]);
            }
            in.nextLine();
            long res = 0;
            for (int i = 0; i < n; i++) {
                final int top = a[i] - minA;
                final int bot = b[i] - minB;
                res += Math.max(top, bot);
            }
            System.out.println(res);
        }
    }
}
