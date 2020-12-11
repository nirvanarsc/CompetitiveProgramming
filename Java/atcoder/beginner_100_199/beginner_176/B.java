package atcoder.beginner_100_199.beginner_176;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public final class B {

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final String line = in.nextLine();
        int digitsSum = 0;
        for (char c : line.toCharArray()) {
            digitsSum = (digitsSum + c - '0') % 9;
        }
        System.out.println(digitsSum == 0 ? "Yes" : "No");
    }
}
