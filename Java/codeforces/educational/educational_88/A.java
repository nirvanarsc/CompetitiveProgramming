package codeforces.educational.educational_88;

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
            final int k = in.nextInt();
            in.nextLine();
            final int cards = n / k;
            final int maxJ = Math.min(cards, m);
            int minJ = 0;
            while (minJ * (k - 1) + maxJ < m) {
                minJ++;
            }
            System.out.println(maxJ-minJ);
        }
    }
}
