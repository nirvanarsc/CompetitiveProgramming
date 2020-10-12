package codeforces.educational_91;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public final class A {

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int t = Integer.parseInt(in.nextLine());
        outer:
        for (int x = 0; x < t; x++) {
            final int n = Integer.parseInt(in.nextLine());
            final int[] arr = new int[n];
            for (int idx = 0; idx < n; idx++) {
                arr[idx] = in.nextInt();
            }
            in.nextLine();
            for (int i = 0; i < n - 2; i++) {
                if (arr[i] < arr[i + 1] && arr[i + 1] > arr[i + 2]) {
                    System.out.println("YES");
                    System.out.println((i + 1) + " " + (i + 2) + ' ' + (i + 3));
                    continue outer;
                }
            }
            System.out.println("NO");
        }
    }
}
