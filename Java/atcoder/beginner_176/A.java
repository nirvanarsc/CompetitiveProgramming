package atcoder.beginner_176;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public final class A {

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final String[] line = in.nextLine().split(" ");
        final int n = Integer.parseInt(line[0]);
        final int x = Integer.parseInt(line[1]);
        final int t = Integer.parseInt(line[2]);
        final int full = n / x + (n % x != 0 ? 1 : 0);
        System.out.println(full * t);
    }
}
