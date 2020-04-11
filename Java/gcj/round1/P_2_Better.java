package gcj.round1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public final class P_2_Better {

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int t = in.nextInt();
        for (int x = 1; x <= t; ++x) {
            int n = in.nextInt();
            final List<List<Integer>> res = new ArrayList<>();
            if (n < 30) {
                for (int i = 1; i <= n; ++i) {
                    res.add(Arrays.asList(i, 1));
                }
            } else {
                n -= 30;
                boolean b = true;
                for (int i = 1; i <= 30; ++i) {
                    res.add(Arrays.asList(i, b ? 1 : i));
                    if ((n >> i - 1 & 1) > 0) {
                        for (int j = 1; j < i; ++j) {
                            res.add(Arrays.asList(i, b ? (j + 1) : (i - j)));
                        }
                        b = !b;
                    }
                }
                for (int i = 31, j = Integer.bitCount(n); j > 0; --j, ++i) {
                    res.add(Arrays.asList(i, b ? 1 : i));
                }
            }
            System.out.println("Case #" + x + ':');
            for (List<Integer> p : res) {
                System.out.println(p.get(0) + " " + p.get(1));
            }
        }
    }
}
