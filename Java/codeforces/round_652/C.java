package codeforces.round_652;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public final class C {

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int t = Integer.parseInt(in.nextLine());
        for (int x = 0; x < t; x++) {
            final int n = in.nextInt();
            final int k = in.nextInt();
            in.nextLine();
            final int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }
            in.nextLine();
            Arrays.sort(arr);
            int start = 0;
            int end = n - 1;
            long res = 0;
            final List<Integer> weight = new ArrayList<>();
            for (int i = 0; i < k; i++) {
                final int curr = in.nextInt();
                if (curr == 1) {
                    res += arr[end];
                    res += arr[end];
                    end--;
                } else {
                    weight.add(curr);
                }
            }
            weight.sort(Collections.reverseOrder());
            for (int w : weight) {
                res += arr[end--];
                res += arr[start++];
                start += w - 2;
            }
            System.out.println(res);
        }
    }
}
