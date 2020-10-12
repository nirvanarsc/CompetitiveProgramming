package codeforces.round_644;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public final class B {

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int t = in.nextInt();
        for (int x = 0; x < t; x++) {
            final int n = in.nextInt();
            final int[] athletes = new int[n];
            for (int i = 0; i < n; i++) {
                athletes[i] = in.nextInt();
            }
            in.nextLine();
            int res = Integer.MAX_VALUE;
            Arrays.sort(athletes);
            for (int i = 1; i < athletes.length; i++) {
                res = Math.min(res, athletes[i] - athletes[i - 1]);
            }
            System.out.println(res);
        }
    }
}
