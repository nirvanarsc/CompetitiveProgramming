package codeforces.global_8;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public final class A {

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int t = Integer.parseInt(in.nextLine());
        for (int x = 0; x < t; x++) {
            final String[] str = in.nextLine().split(" ");
            int a = Integer.parseInt(str[0]);
            int b = Integer.parseInt(str[1]);
            final int n = Integer.parseInt(str[2]);
            int count = 0;
            while (a <= n && b <= n) {
                if (a < b) {
                    a += b;
                } else {
                    b += a;
                }
                count++;
            }
            System.out.println(count);
        }
    }
}
