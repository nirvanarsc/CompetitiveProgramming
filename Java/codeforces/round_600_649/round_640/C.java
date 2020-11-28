package codeforces.round_600_649.round_640;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public final class C {

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int t = in.nextInt();
        for (int x = 0; x < t; x++) {
            final int n = in.nextInt();
            final int k = in.nextInt();
            final int i = k % (n - 1);
            System.out.println((k / (n - 1)) * n + (i == 0 ? -1 : i));
        }
    }
}
