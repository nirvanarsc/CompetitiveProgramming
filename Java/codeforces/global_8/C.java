package codeforces.global_8;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public final class C {

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int n = Integer.parseInt(in.nextLine());
        int x = 0;
        int y = 0;
        System.out.println((n + 1) * 3 + 1);
        for (int k = 0; k <= n; k++, x++, y++) {
            System.out.println((x + 1) + " " + y);
            System.out.println(x + " " + y);
            System.out.println(x + " " + (y + 1));
        }
        System.out.println(x + " " + y);
    }
}
