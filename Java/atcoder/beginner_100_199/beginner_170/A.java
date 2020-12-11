package atcoder.beginner_100_199.beginner_170;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public final class A {

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        for (int i = 1; i <= 5; i++) {
            final int curr = in.nextInt();
            if (curr == 0) {
                System.out.println(i);
                break;
            }
        }
    }
}
