package codeforces.educational_92;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public final class C {

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int t = Integer.parseInt(in.nextLine());
        for (int x = 0; x < t; x++) {
            final String str = in.nextLine();
            int res = 0;
            for (int a = 0; a <= 9; a++) {
                for (int b = 0; b <= 9; b++) {
                    int aCount = 0, bCount = 0;
                    for (char c : str.toCharArray()) {
                        final int d = c - '0';
                        if (aCount <= bCount) {
                            if (d == a) { aCount++; }
                        } else {
                            if (d == b) { bCount++; }
                        }
                    }
                    res = Math.max(res, a == b ? aCount + bCount : 2 * bCount);
                }
            }
            System.out.println(str.length() - res);
        }
    }
}
