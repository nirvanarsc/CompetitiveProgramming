package atcoder.beginner_174;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public final class C {

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int n = Integer.parseInt(in.nextLine());
        int rem = 0;
        for (int i = 0; i < n; i++) {
            rem = ((rem * 10) % n + 7 % n) % n;
            if (rem == 0) {
                System.out.println(i + 1);
                return;
            }
        }
        System.out.println(-1);
    }
}
