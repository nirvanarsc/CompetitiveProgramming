package atcoder.beginner_100_199.beginner_103;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public final class B {

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        String first = in.nextLine();
        first += first;
        final String second = in.nextLine();
        System.out.println(first.contains(second) ? "Yes" : "No");
    }
}
