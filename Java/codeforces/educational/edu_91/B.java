package codeforces.educational.edu_91;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public final class B {

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int t = Integer.parseInt(in.nextLine());
        for (int x = 0; x < t; x++) {
            final String str = in.nextLine();
            final int[] count = new int[128];
            for (char c : str.toCharArray()) {
                count[c]++;
            }
            if (count['R'] >= count['P'] && count['R'] >= count['S']) {
                System.out.println("P".repeat(str.length()));
            } else if (count['P'] >= count['R'] && count['P'] >= count['S']) {
                System.out.println("S".repeat(str.length()));
            } else {
                System.out.println("R".repeat(str.length()));
            }
        }
    }
}
