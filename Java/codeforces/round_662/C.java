package codeforces.round_662;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public final class C {

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int t = Integer.parseInt(in.nextLine());
        for (int x = 0; x < t; x++) {
            final int n = Integer.parseInt(in.nextLine());
            final int[] count = new int[(int) 1e5 + 1];
            int max = 0;
            for (int i = 0; i < n; i++) {
                max = Math.max(max, ++count[in.nextInt()]);
            }
            in.nextLine();
            int rep = 0;
            for (int value : count) {
                if (value == max) {
                    rep++;
                }
            }
            System.out.println((n - rep) / (max - 1) - 1);
        }
    }
}
