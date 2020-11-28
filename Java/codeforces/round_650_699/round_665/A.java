package codeforces.round_650_699.round_665;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public final class A {

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int t = Integer.parseInt(in.nextLine());
        for (int x = 0; x < t; x++) {
            final String[] line = in.nextLine().split(" ");
            final int a = Integer.parseInt(line[0]);
            final int k = Integer.parseInt(line[1]);
            if (a % 2 == 0) {
                if (k <= a) {
                    System.out.println(k % 2);
                } else {
                    System.out.println(k - a);
                }
            } else {
                if (k <= a) {
                    System.out.println(k % 2 == 0 ? 1 : 0);
                } else {
                    System.out.println(k - a);
                }
            }
        }
    }
}
