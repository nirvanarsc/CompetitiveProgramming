package codeforces.round_648;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public final class E {

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int n = in.nextInt();
        final long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextLong();
        }
        in.nextLine();
        long res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    res = Math.max(res, arr[i] | arr[j] | arr[k]);
                }
            }
        }
        System.out.println(res);
    }
}
