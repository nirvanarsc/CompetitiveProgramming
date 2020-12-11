package atcoder.beginner_100_199.beginner_167;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public final class A {

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final String first = in.nextLine();
        final String second = in.nextLine();
        if (first.equals(second.substring(0, second.length() - 1))) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
