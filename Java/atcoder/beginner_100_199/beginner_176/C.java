package atcoder.beginner_100_199.beginner_176;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public final class C {

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int n = Integer.parseInt(in.nextLine());
        final int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        in.nextLine();
        int currMax = 0;
        long res = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] > currMax) {
                currMax = arr[i];
            } else {
                res += currMax - arr[i];
            }
        }
        System.out.println(res);
    }
}
