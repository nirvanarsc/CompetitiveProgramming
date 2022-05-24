package codeforces.educational.edu_87;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public final class C {

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int t = in.nextInt();
        for (int x = 0; x < t; x++) {
            final int n = in.nextInt() * 2;
            final double a = 1.0 / (2 * Math.tan(Math.toRadians(180.0 / n)));
            System.out.println(2 * a);
        }
    }
}
