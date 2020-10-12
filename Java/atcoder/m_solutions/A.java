package atcoder.m_solutions;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public final class A {

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int n = Integer.parseInt(in.nextLine());
        if (1800 <= n && n <= 1999) {
            System.out.println(1);
        } else if (1600 <= n && n <= 1799) {
            System.out.println(2);
        } else if (1400 <= n && n <= 1599) {
            System.out.println(3);
        } else if (1200 <= n && n <= 1399) {
            System.out.println(4);
        } else if (1000 <= n && n <= 1199) {
            System.out.println(5);
        } else if (800 <= n && n <= 999) {
            System.out.println(6);
        } else if (600 <= n && n <= 799) {
            System.out.println(7);
        } else if (400 <= n && n <= 599) {
            System.out.println(8);
        }
    }
}
