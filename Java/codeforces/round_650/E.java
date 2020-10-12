package codeforces.round_650;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public final class E {

    public static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int t = Integer.parseInt(in.nextLine());
        for (int x = 0; x < t; x++) {
            final int n = in.nextInt();
            final int k = in.nextInt();
            in.nextLine();
            final String str = in.nextLine();
            final int[] f = new int[26];
            for (char c : str.toCharArray()) {
                f[c - 'a']++;
            }
            for (int j = n; j >= 1; j--) {
                final int gcd = gcd(j, k);
                int amt = 0;
                for (int freq : f) {
                    amt += freq / (j / gcd);
                }
                if (amt >= gcd) {
                    System.out.println(j);
                    break;
                }
            }
        }
    }

    private E() {}
}
