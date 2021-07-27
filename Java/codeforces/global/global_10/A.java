package codeforces.global.global_10;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public final class A {

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int t = Integer.parseInt(in.nextLine());
        for (int x = 0; x < t; x++) {
            final int n = Integer.parseInt(in.nextLine());
            final int[] arr = new int[n];
            boolean allEqual = true;
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
                if (i > 0 && arr[i] != arr[i - 1]) {
                    allEqual = false;
                }
            }
            in.nextLine();
            System.out.println(allEqual ? n : 1);
        }
    }
}
