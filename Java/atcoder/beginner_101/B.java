package atcoder.beginner_101;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public final class B {

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int n = Integer.parseInt(in.nextLine());
        int sum = 0;
        int copy = n;
        while (copy > 0) {
            sum += copy % 10;
            copy /= 10;
        }
        System.out.println(n % sum == 0 ? "Yes" : "No");
    }
}
