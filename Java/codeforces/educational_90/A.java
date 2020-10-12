package codeforces.educational_90;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

import utils.DataStructures.TreeNode;

public final class A {

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int t = Integer.parseInt(in.nextLine());
        for (int x = 0; x < t; x++) {
            final int a = in.nextInt();
            final int b = in.nextInt();
            final int c = in.nextInt();
            in.nextLine();
            final double p2 = c / (b * 1.0);
            int first = -1;
            if (a < c) {
                first = 1;
            }
            int second = -1;
            if (a > p2) {
                second = b;
            }
            System.out.println(first + " " + second);
        }
    }
}
