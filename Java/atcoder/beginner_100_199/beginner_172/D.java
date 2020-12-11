package atcoder.beginner_100_199.beginner_172;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public final class D {

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int n = Integer.parseInt(in.nextLine());
        long res = 0;
        final int[] count = new int[n + 1];
        for (int i = 1; i <= n; ++i) {
            for (int j = i; j <= n; j += i) {
                count[j]++;
            }
        }
        System.out.println(Arrays.toString(count));
        for (int i = 1; i <= n; ++i) {
            res += (long) count[i] * i;
        }
        System.out.println(res);
    }

    private static long f(int n) {
        long res = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n / i; j++) {
                res += i * j;
            }
        }
        return res;
    }
}
