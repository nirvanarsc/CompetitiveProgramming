package codeforces.round_663;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public final class C {

    private static final int MOD = (int) (1e9 + 7);

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int n = Integer.parseInt(in.nextLine());
        long f = 1;
        long p = 1;
        for (int i = 2; i <= n; i++) {
            f = (f * i) % MOD;
            p = (p * 2) % MOD;
        }
        System.out.println(Math.floorMod(f - p, MOD));
    }
}
