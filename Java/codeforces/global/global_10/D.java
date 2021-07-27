package codeforces.global.global_10;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public final class D {

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int t = Integer.parseInt(in.nextLine());
        for (int x = 0; x < t; x++) {
            final int n = Integer.parseInt(in.nextLine());
            final String str = in.nextLine();
            int start = -1;
            for (int i = 0; i < n - 1; i++) {
                if (str.charAt(i) != str.charAt(i + 1)) {
                    start = i + 1;
                    break;
                }
            }
            if (start == -1) {
                System.out.println(n / 2);
            } else {
                int res = 0;
                final char[] rotated = new char[n];
                for (int i = start, j = 0; j < n; j++, i = (i + 1) % n) {
                    rotated[j] = str.charAt(i);
                }
                for (int i = 0; i < n - 1; i++) {
                    if (rotated[i] == rotated[i + 1]) {
                        int j = i + 1;
                        while (j < n && rotated[j - 1] == rotated[j]) {
                            j++;
                        }
                        res += (j - i - 1) / 2;
                        i = j - 1;
                    }
                }
                System.out.println(res);
            }
        }
    }
}
