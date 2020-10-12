package atcoder.beginner_165;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public final class E {

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int sheep = in.nextInt();
        final int wolves = in.nextInt();
        System.out.println(sheep <= wolves ? "unsafe" : "safe");
    }
}
