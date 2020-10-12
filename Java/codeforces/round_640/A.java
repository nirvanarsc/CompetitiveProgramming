package codeforces.round_640;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public final class A {

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int t = in.nextInt();
        for (int x = 0; x < t; x++) {
            int n = in.nextInt();
            final List<Integer> res = new ArrayList<>();
            int i = 1;
            while (n > 0) {
                final int e = (n % 10) * i;
                if (e != 0) {
                    res.add(e);
                }
                n /= 10;
                i *= 10;
            }
            System.out.println(res.size());
            for (int z : res) {
                System.out.print(z + " ");
            }
            System.out.println();
        }
    }
}
