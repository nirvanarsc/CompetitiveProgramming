package codeforces.round_646;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public final class C {

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int t = in.nextInt();
        for (int x = 0; x < t; x++) {
            final int n = in.nextInt();
            final int special = in.nextInt();
            in.nextLine();
            int degree = 0;
            for (int i = 0; i < n - 1; i++) {
                final int p = in.nextInt();
                final int q = in.nextInt();
                in.nextLine();
                if (p == special || q == special) {
                    degree++;
                }
            }
            System.out.println(degree <= 1 || n % 2 == 0 ? "Ayush" : "Ashish");
        }
    }
}
