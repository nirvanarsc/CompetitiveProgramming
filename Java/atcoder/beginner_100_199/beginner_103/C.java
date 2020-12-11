package atcoder.beginner_100_199.beginner_103;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public final class C {

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int n = Integer.parseInt(in.nextLine());
        final int[] arr = new int[n];
        int res = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
            res += arr[i] - 1;
        }
        System.out.println(res);
    }
}
