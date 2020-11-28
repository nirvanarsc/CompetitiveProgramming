package codeforces.educational.educational_90;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public final class C {

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int t = Integer.parseInt(in.nextLine());
        for (int x = 0; x < t; x++) {
            final String s = in.nextLine();
            System.out.println(f(s));
        }
    }

    private static long f(String s) {
        long res = 0;
        long count = 0;
        for (int i = 0; i < s.length(); i++) {
            count += s.charAt(i) == '+' ? 1 : -1;
            if (count < 0) {
                count = 0;
                res += i + 1;
            }
        }
        return res + s.length();
    }
}
