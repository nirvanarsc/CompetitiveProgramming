package codeforces.round_650_699.round_657;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public final class B {

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int t = Integer.parseInt(in.nextLine());
        outer:
        for (int x = 0; x < t; x++) {
            final String[] line = in.nextLine().split(" ");
            final int l = Integer.parseInt(line[0]);
            final int r = Integer.parseInt(line[1]);
            final long m = Long.parseLong(line[2]);
            for (int a = l; a <= r; a++) {
                final long b;
                final long c;
                final long rem = m % a;
                if (rem + (r - l) >= a) {
                    b = l;
                    c = a - rem + l;
                } else {
                    if (m / a == 0) {
                        continue;
                    }
                    b = l + rem;
                    c = l;
                }
                if (l <= b && b <= r && l <= c && c <= r && (m + c - b) % a == 0 && (m + c - b) / a > 0) {
                    System.out.println(a + " " + b + ' ' + c);
                    continue outer;
                }
            }
        }
    }
}
