package codeforces.educational.educational_91;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public final class C {

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int t = Integer.parseInt(in.nextLine());
        for (int test = 0; test < t; test++) {
            final int n = in.nextInt();
            final int x = in.nextInt();
            in.nextLine();
            final int[] arr = new int[n];
            for (int idx = 0; idx < n; idx++) {
                arr[idx] = in.nextInt();
            }
            in.nextLine();
            Arrays.sort(arr);
            int res = 0;
            int currL = 1;
            for (int i = n - 1; i >= 0; i--) {
                if (currL * arr[i] >= x) {
                    res++;
                    currL = 1;
                } else {
                    currL++;
                }
            }
            System.out.println(res);
        }
    }
}
