package atcoder.tokio_marine;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public final class C {

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int n = in.nextInt();
        final int k = in.nextInt();
        in.nextLine();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        for (int i = 0; i < k; i++) {
            final int[] next = new int[n];
            for (int j = 0; j < n; j++) {
                final int left = Math.max(0, j - arr[j]);
                final int right = Math.min(n - 1, j + arr[j]);
                next[left]++;
                if (right + 1 < n) {
                    next[right + 1]--;
                }
            }
            for (int j = 1; j < n; j++) {
                next[j] += next[j - 1];
            }
            if (Arrays.equals(next, arr)) {
                break;
            }
            arr = next;
        }
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
