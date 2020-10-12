package codeforces.round_650;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public final class B {

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int t = Integer.parseInt(in.nextLine());
        for (int x = 0; x < t; x++) {
            final int n = Integer.parseInt(in.nextLine());
            final int[] arr = new int[n];
            int odds = 0;
            int evens = 0;
            int mismatched = 0;
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
                if (i % 2 != arr[i] % 2) {
                    mismatched++;
                }
                if (arr[i] % 2 == 0) {
                    evens++;
                } else {
                    odds++;
                }
            }
            in.nextLine();
            if (mismatched == 0) {
                System.out.println(0);
                continue;
            }
            if (n % 2 == 0 && odds != evens) {
                System.out.println(-1);
                continue;
            }
            if (n % 2 == 1 && odds + 1 != evens) {
                System.out.println(-1);
                continue;
            }
            System.out.println(mismatched / 2);
        }
    }
}
