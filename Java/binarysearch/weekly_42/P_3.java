package binarysearch.weekly_42;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.IntStream;

public class P_3 {

    public int[] solveSweep(int[][] requests, int k) {
        final int n = requests.length;
        final List<Integer> res = new ArrayList<>();
        final TreeMap<Integer, List<int[]>> tm = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            final int[] rq = requests[i];
            tm.computeIfAbsent(rq[0], v -> new ArrayList<>()).add(new int[] { 1, i });
            tm.computeIfAbsent(rq[1] + 1, v -> new ArrayList<>()).add(new int[] { -1, i });
        }
        final Set<Integer> open = new HashSet<>();
        boolean shift = false;
        outer:
        for (Map.Entry<Integer, List<int[]>> e : tm.entrySet()) {
            final List<int[]> list = e.getValue();
            list.sort(Comparator.comparingInt(a -> a[0]));
            for (int[] val : list) {
                if (val[0] == 1) {
                    open.add(val[1]);
                    if (open.size() > k) {
                        if (!shift) {
                            res.addAll(open);
                            shift = true;
                        } else {
                            res.add(val[1]);
                        }
                    }
                } else {
                    open.remove(val[1]);
                    if (--k < 0) {
                        break outer;
                    }
                }
            }
        }
        return res.stream().mapToInt(Integer::intValue).sorted().toArray();
    }

    public int[] solve(int[][] requests, int k) {
        final List<int[]> list = new ArrayList<>(Arrays.asList(requests));
        list.sort(Comparator.comparingInt(val -> val[0]));
        final int earliest = list.get(k)[0];
        list.sort(Comparator.comparingInt(val -> val[1]));
        final int latest = list.get(k)[1];
        return IntStream.range(0, requests.length)
                        .filter(i -> earliest <= requests[i][1] && requests[i][0] <= latest)
                        .toArray();
    }
}
