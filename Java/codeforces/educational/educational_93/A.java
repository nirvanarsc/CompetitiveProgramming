package codeforces.educational.educational_93;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public final class A {

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int t = Integer.parseInt(in.nextLine());
        for (int x = 0; x < t; x++) {
            final int n = Integer.parseInt(in.nextLine());
            final long[] arr = new long[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextLong();
            }
            in.nextLine();
            if ((arr[0] + arr[1]) <= arr[n - 1]) {
                System.out.println("1 2 " + n);
            } else {
                System.out.println("-1");
            }
        }
    }
}
