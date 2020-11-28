package codeforces.round_600_649.round_646;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public final class B {

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int t = in.nextInt();
        in.nextLine();
        for (int x = 0; x < t; x++) {
            final String str = in.nextLine();
            int ones = 0;
            int zeroes = 0;
            for (int k = 0; k < str.length(); k++) {
                if (str.charAt(k) == '1') {
                    ones++;
                } else {
                    zeroes++;
                }
            }
            int min = Math.min(ones, zeroes);
            System.out.println(Math.min(min, Math.min(f(str), fRev(str))));
        }
    }

    private static int f(String str) {
        int res = 0;
        if (str.charAt(0) == '1') {
            final int zeroIdx = str.indexOf('0');
            if (zeroIdx != -1) {
                int ones = 0;
                int zeroes = 0;
                for (int k = zeroIdx; k < str.length(); k++) {
                    if (str.charAt(k) == '1') {
                        ones++;
                    } else {
                        zeroes++;
                    }
                }
                res = Math.min(ones, zeroes);
            }
        } else {
            final int oneIdx = str.indexOf('1');
            if (oneIdx != -1) {
                int ones = 0;
                int zeroes = 0;
                for (int k = oneIdx; k < str.length(); k++) {
                    if (str.charAt(k) == '1') {
                        ones++;
                    } else {
                        zeroes++;
                    }
                }
                res = Math.min(ones, zeroes);
            }
        }
        return res;
    }

    private static int fRev(String str) {
        int res = 0;
        if (str.charAt(str.length() - 1) == '1') {
            final int zeroIdx = str.lastIndexOf('0');
            if (zeroIdx != -1) {
                int ones = 0;
                int zeroes = 0;
                for (int k = zeroIdx; k >= 0; k--) {
                    if (str.charAt(k) == '1') {
                        ones++;
                    } else {
                        zeroes++;
                    }
                }
                res = Math.min(ones, zeroes);
            }
        } else {
            final int oneIdx = str.lastIndexOf('1');
            if (oneIdx != -1) {
                int ones = 0;
                int zeroes = 0;
                for (int k = oneIdx; k >= 0; k--) {
                    if (str.charAt(k) == '1') {
                        ones++;
                    } else {
                        zeroes++;
                    }
                }
                res = Math.min(ones, zeroes);
            }
        }
        return res;
    }
}
