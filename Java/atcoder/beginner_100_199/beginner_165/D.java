package atcoder.beginner_100_199.beginner_165;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public final class D {

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final long a = in.nextLong();
        final long b = in.nextLong();
        final long n = in.nextLong();
        in.nextLine();
        System.out.println(f(a, Math.min(n, b - 1), b));
    }

    private static long f(long a, long mid, long b) {
        return Math.floorDiv(a * mid, b) - a * Math.floorDiv(mid, b);
    }
}
