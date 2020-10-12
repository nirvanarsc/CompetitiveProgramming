package atcoder.m_solutions;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public final class D {

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int n = Integer.parseInt(in.nextLine());
        final int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        in.nextLine();
        long curr = 1000;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - arr[i - 1] > 0) {
                final long buy = curr / arr[i - 1];
                curr %= arr[i - 1];
                final long profit = arr[i] * buy;
                curr += profit;
            }
        }
        System.out.println(curr);
    }
}
