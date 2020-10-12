package atcoder.beginner_174;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public final class E {

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final String[] line = in.nextLine().split(" ");
        final int n = Integer.parseInt(line[0]);
        final int k = Integer.parseInt(line[1]);
        final int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        in.nextLine();
        int lo = 1, hi = (int) 1e9;
        while (lo < hi) {
            final int mid = lo + hi >>> 1;
            int cuts = 0;
            for (int i = 0; i < n; i++) {
                cuts += (arr[i] - 1) / mid;
            }
            if (k < cuts) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        System.out.println(lo);
    }
}
