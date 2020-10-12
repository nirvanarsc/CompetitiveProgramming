package codeforces.round_661;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public final class C {

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int t = Integer.parseInt(in.nextLine());
        for (int x = 0; x < t; x++) {
            final int n = Integer.parseInt(in.nextLine());
            final int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }
            in.nextLine();
            Arrays.sort(arr);
            int res = 0;
            for (int s = 2; s <= 100; s++) {
                int curr = 0;
                int lo = 0;
                int hi = n - 1;
                while (lo < hi) {
                    if (arr[lo] + arr[hi] < s) {
                        lo++;
                    } else if (arr[lo] + arr[hi] > s) {
                        hi--;
                    } else {
                        curr++;
                        lo++;
                        hi--;
                    }
                }
                res = Math.max(curr, res);
            }
            System.out.println(res);
        }
    }
}
