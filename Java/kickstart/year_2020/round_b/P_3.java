package kickstart.year_2020.round_b;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public final class P_3 {

    private static final int[][] DIRS = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    public static void main(String[] args) {
        final Map<Character, Integer> map = new HashMap<>();
        map.put('N', 3);
        map.put('S', 2);
        map.put('W', 1);
        map.put('E', 0);
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        final int t = in.nextInt();
        final int max = (int) 1e9;
        in.nextLine();
        for (int x = 1; x <= t; x++) {
            final String inst = in.nextLine();
            final Deque<Integer> steps = new ArrayDeque<>();
            final Deque<long[]> coords = new ArrayDeque<>(Collections.singleton(new long[] { 0, 0 }));
            for (char c : inst.toCharArray()) {
                if ('2' <= c && c <= '9') {
                    steps.addFirst(c - '0');
                } else if (c == '(') {
                    coords.addFirst(new long[] { 0, 0 });
                } else if (c == ')') {
                    final int loop = steps.removeFirst();
                    final long[] ints = coords.removeFirst();
                    coords.element()[0] = (coords.element()[0] + loop * ints[0]) % max;
                    coords.element()[1] = (coords.element()[1] + loop * ints[1]) % max;
                } else {
                    final int[] dir = DIRS[map.get(c)];
                    coords.element()[0] += dir[0];
                    coords.element()[1] += dir[1];
                }
            }
            final long[] ints = coords.removeFirst();
            ints[0] = Math.floorMod(ints[0] + 1, max);
            ints[1] = Math.floorMod(ints[1] + 1, max);
            ints[0] = ints[0] == 0 ? max : ints[0];
            ints[1] = ints[1] == 0 ? max : ints[1];
            System.out.println("Case #" + x + ": " + ints[1] + ' ' + ints[0]);
        }
    }
}
