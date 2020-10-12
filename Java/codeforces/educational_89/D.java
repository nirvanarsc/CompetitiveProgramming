package codeforces.educational_89;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public final class D {

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int[] sd = sieveOfEratosthenes();
        final int n = in.nextInt();
        in.nextLine();
        final StringBuilder r1 = new StringBuilder();
        final StringBuilder r2 = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int num = in.nextInt();
            final int div = sd[num];
            if (div == 0) {
                r1.append("-1 ");
                r2.append("-1 ");
            } else {
                while (num % div == 0) {
                    num /= div;
                }
                if (num != 1) {
                    r1.append(div + " ");
                    r2.append(num + " ");
                } else {
                    r1.append("-1 ");
                    r2.append("-1 ");
                }
            }
        }
        in.nextLine();
        System.out.println(r1);
        System.out.println(r2);
    }

    private static int[] sieveOfEratosthenes() {
        final int n = (int) 1e7;
        final boolean[] prime = new boolean[n + 1];
        final int[] smallestDiv = new int[n + 1];
        Arrays.fill(prime, true);
        for (int p = 2; p * p <= n; p++) {
            if (prime[p]) {
                for (int i = p * p; i <= n; i += p) {
                    if (smallestDiv[i] == 0) {
                        smallestDiv[i] = p;
                    }
                    prime[i] = false;
                }
            }
        }
        return smallestDiv;
    }
}
