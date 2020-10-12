package atcoder.beginner_166;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public final class A {

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final String last = in.nextLine();
        System.out.println("ABC".equals(last) ? "ARC" : "ABC");
    }
}
