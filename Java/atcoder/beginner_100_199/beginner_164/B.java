package atcoder.beginner_100_199.beginner_164;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public final class B {

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int a = in.nextInt();
        final int b = in.nextInt();
        int c = in.nextInt();
        final int d = in.nextInt();
        boolean t = false;
        while (a > 0 && c > 0) {
            t ^= true;
            if (t) {
                c -= b;
            } else {
                a -= d;
            }
        }
        System.out.println(t ? "Yes" : "No");
    }
}
