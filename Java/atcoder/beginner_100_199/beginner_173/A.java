package atcoder.beginner_100_199.beginner_173;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public final class A {

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int n = Integer.parseInt(in.nextLine());
        int change = n % 1000;
        if (change > 0) {
            change = 1000 - change;
        }
        System.out.println(change);
    }
}
