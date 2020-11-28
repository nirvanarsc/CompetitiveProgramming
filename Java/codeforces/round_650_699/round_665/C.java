package codeforces.round_650_699.round_665;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

@SuppressWarnings("UtilityClassWithoutPrivateConstructor")
public final class C {

    public static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int t = Integer.parseInt(in.nextLine());
        for (int x = 0; x < t; x++) {
            final int n = Integer.parseInt(in.nextLine());
            final int[] arr = new int[n];
            final int[] copy = new int[n];
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
                copy[i] = arr[i];
                min = Math.min(min, arr[i]);
            }
            in.nextLine();
            Arrays.sort(copy);
            boolean res = true;
            for (int i = 0; i < n; i++) {
                if (arr[i] == copy[i]) {
                    continue;
                }
                if (arr[i] % min != 0 || copy[i] % min != 0) {
                    res = false;
                    break;
                }
            }
            System.out.println(res ? "YES" : "NO");
        }
    }
}
