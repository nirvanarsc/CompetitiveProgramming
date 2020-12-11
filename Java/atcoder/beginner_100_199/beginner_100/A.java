package atcoder.beginner_100_199.beginner_100;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public final class A {

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final String[] line = in.nextLine().split(" ");
        final int a = Integer.parseInt(line[0]);
        final int b = Integer.parseInt(line[1]);
        if (Math.max(a, b) > 8) {
            System.out.println(":(");
        } else {
            System.out.println("Yay!");
        }
    }
}
