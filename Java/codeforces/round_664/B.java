package codeforces.round_664;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public final class B {

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final String[] line = in.nextLine().split(" ");
        final int n = Integer.parseInt(line[0]);
        final int m = Integer.parseInt(line[1]);
        int sx = Integer.parseInt(line[2]) - 1;
        int sy = Integer.parseInt(line[3]) - 1;
        final Set<String> visited = new HashSet<>();
        final List<int[]> res = new ArrayList<>();
        res.add(new int[] { sx, sy });
        res.add(new int[] { 0, sy });
        res.add(new int[] { 0, 0 });
        visited.add(sx + "," + sy);
        visited.add(0 + "," + sy);
        visited.add(0 + "," + 0);
        sx = sy = 0;
        boolean dir = true;
        while (res.size() < n * m) {
            sy += dir ? 1 : -1;
            if (sy == m) {
                dir = !dir;
                sy = m - 1;
                sx += 1;
            }
            if (sy == -1) {
                dir = !dir;
                sy = 0;
                sx += 1;
            }
            if (!visited.add(sx + "," + sy)) {
                continue;
            }
            res.add(new int[] { sx, sy });
        }
        for (int[] r : res) {
            System.out.println((r[0] + 1) + " " + (r[1] + 1));
        }
    }
}
