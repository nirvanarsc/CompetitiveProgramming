package codeforces.round_644;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public final class E {

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int t = in.nextInt();
        for (int x = 0; x < t; x++) {
            final int n = in.nextInt();
            final String[] arr = new String[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.next();
            }
            boolean flag = true;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (arr[i].charAt(j) == '1') {
                        final boolean le = j + 1 < n && arr[i].charAt(j + 1) == '0';
                        final boolean re = i + 1 < n && arr[i + 1].charAt(j) == '0';
                        if (le && re) {
                            flag = false;
                        }
                    }
                }
            }
            System.out.println(flag ? "YES" : "NO");
        }
    }
}
