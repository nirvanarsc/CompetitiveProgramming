package codeforces.educational_88;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public final class B {

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int t = in.nextInt();
        for (int k = 0; k < t; k++) {
            final int n = in.nextInt();
            final int m = in.nextInt();
            final long x = in.nextLong();
            final long y = in.nextLong();
            in.nextLine();
            int emptySpaces = 0;
            int doubles = 0;
            for (int i = 0; i < n; i++) {
                String s = in.nextLine();
                for (int j = 0; j < m; j++) {
                    if (s.charAt(j) == '.') {
                        emptySpaces++;
                        if (j < m - 1 && s.charAt(j + 1) == '.') {
                            emptySpaces++;
                            doubles++;
                            j++;
                        }
                    }
                }
            }
            if (2 * x <= y) {
                System.out.println(emptySpaces * x);
            } else {
                System.out.println(doubles * y + (emptySpaces - doubles * 2) * x);
            }
        }
    }
}
