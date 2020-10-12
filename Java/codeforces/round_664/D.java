package codeforces.round_664;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public final class D {

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final String[] line = in.nextLine().split(" ");
        final int n = Integer.parseInt(line[0]);
        final int d = Integer.parseInt(line[1]);
        final int m = Integer.parseInt(line[2]);
        final int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        in.nextLine();
        Arrays.sort(arr);
        final long[] preSum = new long[n];
        preSum[0] = arr[0];
        for (int i = 1; i < n; i++) {
            preSum[i] = preSum[i - 1] + arr[i];
        }
        System.out.println(Math.max(
                calc(d, m, arr, preSum, 0, n - 1, 0),
                calc(d, m, arr, preSum, 0, n - 2, arr[n - 1])

        ));
    }

    private static long calc(int d, int m, int[] arr, long[] preSum, int i, int j, long res) {
        while (i < j) {
            if (arr[j] <= m) {
                res += preSum[j] - (i > 0 ? preSum[i - 1] : 0);
                break;
            } else {
                final long start = preSum[Math.min(j, i + d - 1)] - (i > 0 ? preSum[i - 1] : 0);
                if (arr[j] > start) {
                    res += arr[j--];
                } else {
                    res += start;
                }
                i += d;
            }
        }
        return res;
    }
}
