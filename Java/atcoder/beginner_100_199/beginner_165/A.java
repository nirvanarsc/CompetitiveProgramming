package atcoder.beginner_100_199.beginner_165;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public final class A {

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int k = in.nextInt();
        in.nextLine();
        final int a = in.nextInt();
        final int b = in.nextInt();
        in.nextLine();
        boolean found = false;
        for (int i = a; i <= b; i++) {
            if (i % k == 0) {
                found = true;
                break;
            }
        }
        System.out.println(found ? "OK" : "NG");
    }
}
