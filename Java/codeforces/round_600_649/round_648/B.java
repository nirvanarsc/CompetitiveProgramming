package codeforces.round_600_649.round_648;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public final class B {

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int t = in.nextInt();
        for (int x = 0; x < t; x++) {
            final int n = in.nextInt();
            in.nextLine();
            final int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }
            in.nextLine();
            final int[] arr2 = new int[n];
            int t1 = 0;
            int t2 = 0;
            for (int i = 0; i < n; i++) {
                arr2[i] = in.nextInt();
                if (arr2[i] == 0) {
                    t1++;
                } else {
                    t2++;
                }
            }
            in.nextLine();
            boolean isSorted = true;
            for (int i = 0; i < n - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    isSorted = false;
                    break;
                }
            }
            if (isSorted) {
                System.out.println("Yes");
                continue;
            }
            System.out.println((t1 > 0 && t2 > 0) ? "Yes" : "No");
        }
    }
}
