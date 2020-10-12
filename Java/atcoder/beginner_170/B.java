package atcoder.beginner_170;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public final class B {

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int x = in.nextInt();
        final int y = in.nextInt();
        final int lo = x * 2;
        final int hi = x * 4;
        if (y % 2 == 0 && lo <= y && y <= hi) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
