package atcoder.nomura;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public final class A {

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int h1 = in.nextInt();
        final int m1 = in.nextInt();
        final int h2 = in.nextInt();
        final int m2 = in.nextInt();
        final int k = in.nextInt();
        in.nextLine();
        final int diff = (h2 * 60 + m2) - (h1 * 60 + m1);
        System.out.println(Math.max(0, diff - k));
    }
}
