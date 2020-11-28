package codeforces.round_650_699.round_664;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public final class A {

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        final int t = Integer.parseInt(in.nextLine());
        for (int x = 0; x < t; x++) {
            final String[] line = in.nextLine().split(" ");
            int r = Integer.parseInt(line[0]);
            int g = Integer.parseInt(line[1]);
            int b = Integer.parseInt(line[2]);
            int w = Integer.parseInt(line[3]);
            int evens = 0;
            if (r % 2 == 0) { evens++; }
            if (g % 2 == 0) { evens++; }
            if (b % 2 == 0) { evens++; }
            if (w % 2 == 0) { evens++; }
            if (evens >= 3) {
                System.out.println("Yes");
                continue;
            } else {
                if (r > 0 && g > 0 && b > 0) {
                    r--;
                    g--;
                    b--;
                    w += 3;
                    evens = 0;
                    if (r % 2 == 0) { evens++; }
                    if (g % 2 == 0) { evens++; }
                    if (b % 2 == 0) { evens++; }
                    if (w % 2 == 0) { evens++; }
                    if (evens >= 3) {
                        System.out.println("Yes");
                    } else {
                        System.out.println("No");
                    }
                } else {
                    System.out.println("No");
                }
            }
        }
    }
}
