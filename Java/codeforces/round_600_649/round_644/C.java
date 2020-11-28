package codeforces.round_600_649.round_644;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public final class C {

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int t = in.nextInt();
        for (int x = 0; x < t; x++) {
            final int n = in.nextInt();
            final int[] arr = new int[n];
            int odds = 0;
            int evens = 0;
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
                if (arr[i] % 2 != 0) {
                    odds++;
                } else {
                    evens++;
                }
            }
            if (odds % 2 == 0 && evens % 2 == 0) {
                System.out.println("YES");
                continue;
            }
            Arrays.sort(arr);
            boolean canFinish = false;
            for (int i = 1; i < arr.length; i++) {
                if (arr[i] - arr[i - 1] == 1) {
                    canFinish = true;
                    break;
                }
            }
            System.out.println(canFinish ? "YES" : "NO");
        }
    }
}
