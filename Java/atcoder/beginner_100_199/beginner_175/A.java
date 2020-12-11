package atcoder.beginner_100_199.beginner_175;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public final class A {

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        String s = in.nextLine();
        s = 'S' + s + 'S';
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'R') {
                int j = i;
                while (j < s.length() && s.charAt(j) == 'R') {
                    j++;
                }
                res = Math.max(res, j - i);
                i = j;
            }
        }
        System.out.println(res);
    }
}
