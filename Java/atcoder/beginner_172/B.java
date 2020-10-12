package atcoder.beginner_172;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public final class B {

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final String s = in.nextLine();
        final String t = in.nextLine();
        int diff = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != t.charAt(i)) {
                diff++;
            }
        }
        System.out.println(diff);
    }
}
