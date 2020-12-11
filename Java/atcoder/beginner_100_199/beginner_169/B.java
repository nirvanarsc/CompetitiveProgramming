package atcoder.beginner_100_199.beginner_169;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public final class B {

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int n = in.nextInt();
        final long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextLong();
            if (arr[i] == 0) {
                System.out.println(0);
                return;
            }
        }
        in.nextLine();
        final long limit = (long) 1e18;
        long prod = arr[0];
        for (int i = 1; i < n; i++) {
            if (prod > limit / arr[i]) {
                System.out.println(-1);
                return;
            }
            prod *= arr[i];
        }
        System.out.println(prod);
    }
}
