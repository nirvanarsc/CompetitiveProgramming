package atcoder.nomura;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public final class E {

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final String str = in.nextLine();
        final char[] s = (' ' + str).toCharArray();
        final int n = str.length();
        int cnt1 = 0;
        int cnt0 = 0;
        long res = 0;
        for (int i = 1; i <= n; ++i) {
            cnt1 += (s[i] == '1') ? 1 : 0;
            cnt0 += (s[i] == '0') ? 1 : 0;
        }
        for (int i = 1; i <= cnt1; ++i) {
            res += (i + 1) / 2;
        }
        for (int i = 1, now = 0, x = 0, y = 0; i <= n; ++i) {
            if (s[i] == '1') {
                ++now;
                ++y;
                if ((y & 1) == 1) {
                    res += x / 2;
                } else {
                    res += (x + 1) / 2;
                }
                if ((now & 1) == 1) {
                    res += cnt0 - x;
                }
            } else {
                ++x;
                if ((now & 1) == 1) {
                    ++now;
                }
            }
        }
        System.out.println(res);
    }
}
