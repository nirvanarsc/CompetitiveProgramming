package codeforces.round_600_649.round_644;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public final class F {

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int t = in.nextInt();
        for (int x = 0; x < t; x++) {
            final int n = in.nextInt();
            final int k = in.nextInt();
            final String[] arr = new String[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.next();
            }
            System.out.println(f(arr));
        }
    }

    private static String f(String[] arr) {
        final String first = arr[0];
        for (int i = 0; i < first.length(); i++) {
            final char[] curr = first.toCharArray();
            for (char j = 'a'; j <= 'z'; j++) {
                curr[i] = j;
                boolean go = true;
                for (String str : arr) {
                    int find = 0;
                    for (int a = 0; a < str.length(); a++) {
                        if (curr[a] != str.charAt(a)) { find++; }
                    }
                    if (find > 1) {
                        go = false;
                        break;
                    }
                }
                if (go) {
                    return new String(curr);
                }
            }
        }
        return "-1";
    }
}
