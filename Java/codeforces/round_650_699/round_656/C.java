package codeforces.round_650_699.round_656;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public final class C {

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int t = Integer.parseInt(in.nextLine());
        for (int x = 0; x < t; x++) {
            final int n = Integer.parseInt(in.nextLine());
            final int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }
            in.nextLine();
            int j = n - 2;
            while (j >= 0 && arr[j] >= arr[j + 1]) {
                j--;
            }
            if (j == -1) {
                System.out.println(0);
            } else {
                while (j >= 0 && arr[j] <= arr[j + 1]) {
                    j--;
                }
                System.out.println(j + 1);
            }
        }
    }
}
