package codeforces.round_600_649.round_640;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public final class B {

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int t = in.nextInt();
        for (int x = 0; x < t; x++) {
            final int n = in.nextInt();
            final int k = in.nextInt();
            in.nextLine();
            boolean canOdd = true;
            boolean canEven = true;
            if (n - (k - 1) <= 0 || ((n - (k - 1)) % 2 == 0)) {
                canOdd = false;
            }
            if (n - (k - 1) * 2 <= 0 || ((n - (k - 1) * 2) % 2 != 0)) {
                canEven = false;
            }
            if (!canEven && !canOdd) {
                System.out.println("NO");
            } else {
                System.out.println("YES");
                if (canEven) {
                    for (int i = 0; i < k - 1; i++) {
                        System.out.print(2 + " ");
                    }
                    System.out.println(n - (k - 1) * 2);
                } else {
                    for (int i = 0; i < k - 1; i++) {
                        System.out.print(1 + " ");
                    }
                    System.out.println(n - (k - 1));
                }
            }
        }
    }
}
