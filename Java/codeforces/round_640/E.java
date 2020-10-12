package codeforces.round_640;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public final class E {

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int t = in.nextInt();
        for (int x = 0; x < t; x++) {
            final int n = in.nextInt();
            final int[] arr = new int[n];
            final int[] freq = new int[9000];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
                freq[arr[i]]++;
            }
            int ans = 0;
            for (int i = 0; i < n - 1; i++) {
                int curr = arr[i];
                for (int j = i + 1; j < n; j++) {
                    curr += arr[j];
                    if (curr < 9000) {
                        ans += freq[curr];
                        freq[curr] = 0;
                    }
                }
            }
            System.out.println(ans);
        }
    }
}
