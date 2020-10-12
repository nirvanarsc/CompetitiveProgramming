package atcoder.beginner_102;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public final class D {

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int n = Integer.parseInt(in.nextLine());
        final int[] arr = new int[n + 1];
        final long[] pre = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = in.nextInt();
            pre[i] += pre[i - 1] + arr[i];
        }
        in.nextLine();
        long res = (long) 1e16;
        final long[] diff = new long[4];
        int l = 1, r = 3;
        for (int mid = 2; mid <= n - 2; mid++) {
            while (l < mid && Math.abs(pre[l] - (pre[mid] - pre[l]))
                              >= Math.abs(pre[l + 1] - (pre[mid] - pre[l + 1]))) {
                l++;
            }
            while (r < n && Math.abs(pre[r] - pre[mid] - (pre[n] - pre[r]))
                            >= Math.abs(pre[r + 1] - pre[mid] - (pre[n] - pre[r + 1]))) {
                r++;
            }
            diff[0] = pre[l];
            diff[1] = pre[mid] - pre[l];
            diff[2] = pre[r] - pre[mid];
            diff[3] = pre[n] - pre[r];
            Arrays.sort(diff);
            res = Math.min(res, diff[3] - diff[0]);
        }
        System.out.println(res);
    }
}
