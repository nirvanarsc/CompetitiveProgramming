package codeforces.round_650_699.round_651;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public final class C {

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int t = Integer.parseInt(in.nextLine());
        for (int x = 0; x < t; x++) {
            final int n = Integer.parseInt(in.nextLine());
            System.out.println(dfs(n) ? "FastestFinger": "Ashishgup");
        }
    }

    private static boolean dfs(int n) {
        if (n == 1) {
            return true;
        }
        if (n % 2 != 0) {
            return false;
        }
        int divMax = -1;
        int divMin = Integer.MAX_VALUE;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                if ((n / i) % 2 != 0) {
                    divMax = Math.max(divMax, n / i);
                    divMin = Math.min(divMin, n / i);
                }
                if (i % 2 != 0) {
                    divMax = Math.max(divMax, i);
                    divMin = Math.min(divMin, i);
                }
            }
        }
        if (divMax == -1) {
            return !dfs(n - 1);
        } else {
            if (n % 4 != 0 && divMax != divMin) {
                return !dfs(n / (divMax / divMin));
            }
            return !dfs(n / divMax);
        }
    }
}
