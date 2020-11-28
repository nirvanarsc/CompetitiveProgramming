package codeforces.round_600_649.round_639;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public final class A {

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int t = in.nextInt();
        for (int x = 0; x < t; x++) {
            final int n = in.nextInt();
            final int m = in.nextInt();
            in.nextLine();
            final String res;
            if (n == 1 || m == 1 || (n == 2 && m == 2)) {
                res = "YES";
            } else {
                res = "NO";
            }
            System.out.println(res);
        }
    }
}
