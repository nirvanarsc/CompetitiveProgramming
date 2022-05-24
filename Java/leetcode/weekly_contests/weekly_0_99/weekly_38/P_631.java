package leetcode.weekly_contests.weekly_0_99.weekly_38;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings({ "unused", "MethodParameterNamingConvention" })
public class P_631 {

    static class Excel {

        static class Cell {
            int val;
            final Map<Cell, Integer> vars = new HashMap<>();

            Cell(int v) {val = v;}

            void add(Cell cell) {
                vars.merge(cell, 1, Integer::sum);
            }

            int val() {
                if (vars.isEmpty()) {
                    return val;
                } else {
                    int sum = 0;
                    for (Map.Entry<Cell, Integer> entry : vars.entrySet()) {
                        sum += entry.getValue() * entry.getKey().val();
                    }
                    return sum;
                }
            }

            void set(int v) {
                val = v;
                vars.clear();
            }
        }

        final Cell[][] cells;

        Excel(int H, char W) {
            cells = new Cell[H + 1][W - 'A' + 1];
            for (int i = 0; i < cells.length; i++) {
                for (int j = 0; j < cells[0].length; j++) {
                    cells[i][j] = new Cell(0);
                }
            }
        }

        public void set(int r, char c, int v) {
            cells[r][c - 'A'].set(v);
        }

        public int get(int r, char c) {
            return cells[r][c - 'A'].val();
        }

        public int sum(int r, char c, String[] strs) {
            final Cell cell = cells[r][c - 'A'];
            cell.set(0);
            for (String s : strs) {
                final int k = s.indexOf(':');
                if (k > 0) {
                    final int[] start = position(s.substring(0, k));
                    final int[] end = position(s.substring(k + 1));
                    for (int i = start[0]; i <= end[0]; i++) {
                        for (int j = start[1]; j <= end[1]; j++) {
                            cell.add(cells[i][j]);
                        }
                    }
                } else {
                    final int[] p = position(s);
                    cell.add(cells[p[0]][p[1]]);
                }
            }
            return cell.val();
        }

        int[] position(String s) {
            return new int[] { Integer.parseInt(s.substring(1)), s.charAt(0) - 'A' };
        }
    }
}
