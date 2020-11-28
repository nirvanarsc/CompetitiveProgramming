package codeforces.educational.educational_92;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public final class A {

    public static long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    private static long lcm(long a, long b) {
        return (a * b) / gcd(a, b);
    }

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int t = Integer.parseInt(in.nextLine());
        outer:
        for (int x = 0; x < t; x++) {
            final String[] line = in.nextLine().split(" ");
            final int first = Integer.parseInt(line[0]);
            final int second = Integer.parseInt(line[1]);
            for (long j = first; j <= second / 2; j++) {
                if (lcm(j, j * 2) <= second) {
                    System.out.println(j + " " + j * 2);
                    continue outer;
                }
            }
            System.out.println(-1 + " " + -1);
        }
    }
}
