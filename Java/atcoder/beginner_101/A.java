package atcoder.beginner_101;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public final class A {

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final String line = in.nextLine();
        int res = 0;
        for (char c : line.toCharArray()) {
            res += c == '+' ? 1 : -1;
        }
        System.out.println(res);
    }
}
