package codeforces.global_10;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public final class B {

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int t = Integer.parseInt(in.nextLine());
        for (int x = 0; x < t; x++) {
            final String[] line = in.nextLine().split(" ");
            final int n = Integer.parseInt(line[0]);
            final long k = Long.parseLong(line[1]);
            final int[] arr = new int[n];
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
                max = Math.max(max, arr[i]);
            }
            in.nextLine();
            final int[] next = new int[n];
            for (int i = 0; i < n; i++) {
                next[i] = max - arr[i];
            }
            if (k % 2 != 0) {
                for (int num : next) {
                    System.out.print(num + " ");
                }
            } else {
                max = Integer.MIN_VALUE;
                for (int i = 0; i < n; i++) {
                    max = Math.max(max, next[i]);
                }
                final int[] res = new int[n];
                for (int i = 0; i < n; i++) {
                    res[i] = max - next[i];
                }
                for (int num : res) {
                    System.out.print(num + " ");
                }
            }
            System.out.println();
        }
    }
}
