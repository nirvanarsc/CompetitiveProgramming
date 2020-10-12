package atcoder.beginner_100;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public final class D {

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        String[] line = in.nextLine().split(" ");
        final int n = Integer.parseInt(line[0]);
        final int m = Integer.parseInt(line[1]);
        final long[][] cakes = new long[n][3];
        for (int i = 0; i < n; i++) {
            line = in.nextLine().split(" ");
            cakes[i][0] = Long.parseLong(line[0]);
            cakes[i][1] = Long.parseLong(line[1]);
            cakes[i][2] = Long.parseLong(line[2]);
        }
        long res = 0;
        for (int i = 0; i < 8; i++) {
            final List<Long> curr = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                long S = 0;
                for (int k = 0; k < 3; k++) {
                    if ((i & (1 << k)) != 0) {
                        S += cakes[j][k];
                    } else {
                        S -= cakes[j][k];
                    }
                }
                curr.add(S);
            }
            curr.sort(Comparator.reverseOrder());
            long currRes = 0;
            for (int j = 0; j < m; j++) { currRes += curr.get(j); }
            res = Math.max(res, currRes);
        }
        System.out.println(res);
    }
}
