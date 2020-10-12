package atcoder.beginner_173;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public final class D {

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int n = Integer.parseInt(in.nextLine());
        final long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextLong();
        }
        Arrays.sort(arr);
        int idx = n - 1;
        int count = n - 2;
        long res = arr[idx--];
        while (count >= 2) {
            res += 2 * arr[idx--];
            count -= 2;
        }
        if (count == 1) {
            res += arr[idx];
        }
        System.out.println(res);
    }
}
