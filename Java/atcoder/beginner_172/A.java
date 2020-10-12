package atcoder.beginner_172;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public final class A {

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int a = Integer.parseInt(in.nextLine());
        System.out.println(a + a * a + a * a * a);
    }
}
