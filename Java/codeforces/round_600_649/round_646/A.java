package codeforces.round_600_649.round_646;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public final class A {

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int t = in.nextInt();
        for (int x = 0; x < t; x++) {
            final int n = in.nextInt();
            final int k = in.nextInt();
            in.nextLine();
            int odds = 0;
            int even = 0;
            for (int i = 0; i < n; i++) {
                final int next = in.nextInt();
                if (next % 2 == 0) {
                    even++;
                } else {
                    odds++;
                }
            }
            in.nextLine();
            boolean canDo = false;
            for (int i = 1; i <= k; i += 2) {
                if (odds >= i && even >= (k - i)) {
                    canDo = true;
                    break;
                }
            }
            System.out.println(canDo ? "Yes" : "No");
        }
    }
}
