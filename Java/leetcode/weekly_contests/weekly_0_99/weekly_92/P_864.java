package leetcode.weekly_contests.weekly_0_99.weekly_92;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class P_864 {

    private static final int[][] DIRS = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    static class Pair {
        int x;
        int y;
        int keys;

        Pair(int x, int y, int keys) {
            this.x = x;
            this.y = y;
            this.keys = keys;
        }
    }

    public int shortestPathAllKeys(String[] grid) {
        final Set<String> visited = new HashSet<>();
        final Deque<Pair> q = new ArrayDeque<>();
        int step = 0, max = -1, startX = -1, startY = -1;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length(); j++) {
                final char c = grid[i].charAt(j);
                if ('a' <= c && c <= 'z') {
                    max = Math.max(c - 'a' + 1, max);
                }
                if (c == '@') {
                    startX = i;
                    startY = j;
                }
            }
        }
        visited.add(0 + " " + startX + ' ' + startY);
        q.offerLast(new Pair(startX, startY, 0));
        while (!q.isEmpty()) {
            for (int k = q.size(); k > 0; k--) {
                final Pair curr = q.removeFirst();
                if (curr.keys == (1 << max) - 1) {
                    return step;
                }
                for (int[] dir : DIRS) {
                    final int newX = curr.x + dir[0];
                    final int newY = curr.y + dir[1];
                    int keys = curr.keys;
                    if (newX >= 0 && newX < grid.length && newY >= 0 && newY < grid[0].length()) {
                        final char c = grid[newX].charAt(newY);
                        if (c == '#' || ('A' <= c && c <= 'Z' && (((keys >> (c - 'A')) & 1) == 0))) {
                            continue;
                        }
                        if ('a' <= c && c <= 'z') {
                            keys |= 1 << (c - 'a');
                        }
                        if (!visited.contains(keys + " " + newX + ' ' + newY)) {
                            visited.add(keys + " " + newX + ' ' + newY);
                            q.offerLast(new Pair(newX, newY, keys));
                        }
                    }
                }
            }
            step++;
        }
        return -1;
    }
}
