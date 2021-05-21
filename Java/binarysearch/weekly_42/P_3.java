package binarysearch.weekly_42;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class P_3 {

    public int[] solve(int[][] requests, int k) {
        final int n = requests.length;
        final List<Integer> res = new ArrayList<>();
        final TreeMap<Integer, List<int[]>> tm = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            final int[] rq = requests[i];
            tm.computeIfAbsent(rq[0], v -> new ArrayList<>()).add(new int[] { 1, i });
            tm.computeIfAbsent(rq[1] + 1, v -> new ArrayList<>()).add(new int[] { -1, i });
        }
        int count = 0;
        int closed = 0;
        outer:
        for (Map.Entry<Integer, List<int[]>> e : tm.entrySet()) {
            if (closed == k + 1) {
                break;
            }
            final List<int[]> v = e.getValue();
            boolean l = false;
            boolean r = false;
            v.sort((a, b) -> Integer.compare(a[0], b[0]));
            for (int[] vv : v) {
                if (vv[0] == 1) {
                    count++;
                    if (count == (k + 1)) {
                        l = true;
                    }
                } else {
                    count--;
                    if (count == (k + 1)) {
                        r = true;
                    }
                    closed++;
                    if (closed == k + 1) {
                        break outer;
                    }
                }
            }
            for (int[] vv : v) {
                if (l && vv[0] == 1) {
                    res.add(vv[1]);
                }
                if (r && vv[0] == -1) {
                    res.add(vv[1]);
                }
            }

        }
        return res.stream().mapToInt(Integer::intValue).sorted().distinct().toArray();
    }

    public static void main(String[] args) {
//        System.out.println(Arrays.toString(new P_3().solve(new int[][] { { 0, 1 }, { 2, 3 } }, 0)));
        System.out.println(Arrays.toString(new P_3().solve(new int[][] { { 2, 3 }, { 3, 4 } }, 0)));
        ;
    }
}
