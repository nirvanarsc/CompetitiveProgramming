package codeforces.round_650_699.round_654;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public final class B {

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int t = Integer.parseInt(in.nextLine());
        for (int x = 0; x < t; x++) {
            final long n = in.nextLong();
            final long r = in.nextLong();
            in.nextLine();
            long curr = n;
            long res = 0;
            if (curr <= r) {
                res += 1;
            }
            curr = Math.min(n - 1, r);
            res += (curr + 1) * curr / 2;
            System.out.println(res);
        }
    }
}
