package codeforces.educational.edu_89;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public final class A {

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int t = in.nextInt();
        for (int x = 0; x < t; x++) {
            final long a = in.nextLong();
            final long b = in.nextLong();
            in.nextLine();
            long min = Math.min(a, b);
            long max = Math.max(a, b);
            if (max - min >= min) {
                System.out.println(min);
                continue;
            }
            long res = max - min;
            max -= 2 * res;
            min -= res;
            res += 2 * (max / 3);
            max %= 3;
            min %= 3;
            if (max == 2 && min == 2) {
                res++;
            }
            System.out.println(res);
        }
    }
}
