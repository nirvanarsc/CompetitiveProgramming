package atcoder.beginner_100_199.beginner_102;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public final class C {

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int n = Integer.parseInt(in.nextLine());
        final int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
            arr[i] -= i + 1;
        }
        in.nextLine();
        Arrays.sort(arr);
        System.out.println(f(arr, arr[n / 2]));
    }

    private static long f(int[] arr, int median) {
        long res = 0;
        for (int value : arr) {
            res += Math.abs(value - median);
        }
        return res;
    }
}
