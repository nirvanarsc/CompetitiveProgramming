package codeforces.round_644;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public final class H {

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int t = in.nextInt();
        final StringBuilder sb = new StringBuilder();
        for (int x = 0; x < t; x++) {
            final int n = in.nextInt();
            final int m = in.nextInt();
            in.nextLine();
            final List<Long> rem = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                final String st = in.nextLine();
                long val = 0;
                for (int j = st.length() - 1; j >= 0; j--) {
                    if (st.charAt(j) == '1') {
                        val |= 1L << (st.length() - j - 1);
                    }
                }
                rem.add(val);
            }
            Collections.sort(rem);
            final long k = 1L << m;
            long med = (k - rem.size() + 1) / 2, prev = -1;
            for (int i = 0; i < rem.size(); i++) {
                final long curr = rem.get(i);
                if (curr - prev == 1) {
                    prev = curr;
                    continue;
                }
                final long d = curr - prev - 1;
                if (med - d > 0) {
                    med -= d;
                } else {
                    break;
                }
                prev = curr;
            }
            long ans = med + prev;
            final int[] arr = new int[m];
            int i = 0;
            while (ans != 0) {
                arr[i++] = (int) (ans & 1L);
                ans >>= 1;
            }
            for (int j = m - 1; j >= 0; j--) {
                sb.append(arr[j]);
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }
}
