package codeforces.educational.edu_88;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public final class D {

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int n = in.nextInt();
        in.nextLine();
        final int[] arr = new int[n + 1];
        final String[] line = in.nextLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(line[i]);
        }
        int res = 0;
        for (int x = 0; x <= 30; x++) {
            int sum = 0;
            for (int i = 0; i < n; i++) {
                if (x < arr[i]) {
                    sum = 0;
                    continue;
                } else {
                    sum = Math.max(sum + arr[i], 0);
                    res = Math.max(res, sum - x);
                }
            }
        }
        System.out.print(res);
    }
}
