package codeforces.round_600_649.round_645;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public final class C {

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int t = in.nextInt();
        for (int x = 0; x < t; x++) {
            final int x1 = in.nextInt();
            final int y1 = in.nextInt();
            final int x2 = in.nextInt();
            final int y2 = in.nextInt();
            in.nextLine();
            final long dx = x2 - x1;
            final long dy = y2 - y1;
            System.out.println(dx * dy + 1);
        }
    }
}
