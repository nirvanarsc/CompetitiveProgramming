package atcoder.beginner_100_199.beginner_103;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public final class A {

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int n = 3;
        final int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        in.nextLine();
        Arrays.sort(arr);
        int res = 0;
        for (int i = 0; i < n - 1; i++) {
            res += arr[i + 1] - arr[i];
        }
        System.out.println(res);
    }
}
