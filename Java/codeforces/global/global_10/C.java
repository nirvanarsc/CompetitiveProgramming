package codeforces.global.global_10;

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
            long res = 0;
            for (int i = 0; i < n - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    res += arr[i] - arr[i + 1];
                }
            }
            System.out.println(res);

//            int peak = -1;
//            for (int i = 0; i < n - 1; i++) {
//                if (arr[i] > arr[i + 1]) {
//                    peak = i;
//                    break;
//                }
//            }
//            if (peak == -1) {
//                System.out.println(0);
//                continue;
//            } else {
//                int max = 0;
//                for (int i = peak; i < n; i++) {
//                    max = Math.max(max, arr[i]);
//                }
//                int res = max - arr[peak + 1];
//                for (int i = peak + 1; i < n - 1; i++) {
//                    if (arr[i] > arr[i + 1]) {
//                        res += arr[i] - arr[i + 1];
//                    }
//                }
//                System.out.println(res);
//            }
        }
    }
}
