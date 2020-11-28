package codeforces.round_600_649.round_648;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public final class C {

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int n = in.nextInt();
        in.nextLine();
        final int[] arr = new int[n];
        final int[] m1 = new int[n + 1];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
            m1[arr[i]] = i;
        }
        in.nextLine();
        final int[] arr2 = new int[n];
        final int[] m2 = new int[n + 1];
        for (int i = 0; i < n; i++) {
            arr2[i] = in.nextInt();
            m2[arr2[i]] = i;
        }
        in.nextLine();
        final int[] count = new int[n + 1];
        int res = 0;
        for (int num : arr) {
            int key = m1[num] - m2[num];
            if (key < 0) {
                key += n;
            }
            res = Math.max(res, ++count[key]);
        }
        System.out.println(res);
    }
}
