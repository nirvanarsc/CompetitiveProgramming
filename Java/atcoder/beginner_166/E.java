package atcoder.beginner_166;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public final class E {

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int n = in.nextInt();
        in.nextLine();
        final int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        long res = 0;
        final int[] mp = new int[n + 1];
        for (int i = 0; i < n; i++) {
            if (i - arr[i] >= 0) {
                res += mp[i - arr[i]];
            }
            if (arr[i] + i <= n) {
                mp[arr[i] + i]++;
            }
        }
        System.out.println(res);
    }
}
