package codeforces.educational.edu_90;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public final class D {

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int t = Integer.parseInt(in.nextLine());
        for (int x = 0; x < t; x++) {
            final int n = Integer.parseInt(in.nextLine());
            final int[] arr = new int[n];
            long evenSum = 0;
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
                if (i % 2 == 0) {
                    evenSum += arr[i];
                    arr[i] *= -1;
                }
            }
            final long[] prefixSum = new long[n + 1];
            for (int i = 0; i < n; i++) {
                prefixSum[i + 1] = prefixSum[i] + arr[i];
            }
            final long[] minSums = { (long) 1e18, (long) 1e18 };
            long best = 0;
            for (int i = 0; i <= n; i++) {
                best = Math.max(best, prefixSum[i] - minSums[i % 2]);
                minSums[i % 2] = Math.min(minSums[i % 2], prefixSum[i]);
            }
            in.nextLine();
            System.out.println(evenSum + best);
        }
    }
}
