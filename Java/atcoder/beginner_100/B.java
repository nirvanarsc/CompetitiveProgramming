package atcoder.beginner_100;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public final class B {

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final String[] line = in.nextLine().split(" ");
        final int a = Integer.parseInt(line[0]);
        final int b = Integer.parseInt(line[1]);
        final long pow = Math.round(Math.pow(100, a));
        if (b <= 99) {
            System.out.println(b * pow);
        } else {
            System.out.println(101 * pow);
        }
    }
}
