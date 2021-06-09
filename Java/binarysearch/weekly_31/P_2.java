package binarysearch.weekly_31;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P_2 {

    public int[] solve(int[] nums, int[] queries, int w) {
        int n = nums.length;
        int[] count = new int[n];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(nums[i], val -> new ArrayList<>()).add(i);
            if (i < n / 2) {
                count[i] = Math.min(i + 1, w);
            } else {
                count[i] = Math.min(n - i, w);
            }
        }

        System.out.println(Arrays.toString(count));
        Map<Integer, Integer> f = new HashMap<>();

        for (Map.Entry<Integer, List<Integer>> e : map.entrySet()) {
            int key = e.getKey();
            Deque<Integer> dq = new ArrayDeque<>();
            for (int idx : e.getValue()) {
                if (!dq.isEmpty() && dq.getFirst() + w <= idx) {
                    f.merge(key, count[dq.removeFirst()], Integer::sum);
                }
                if (dq.isEmpty()) {
                    dq.addFirst(idx);
                } else if (count[dq.getFirst()] < count[idx]) {
                    dq.removeFirst();
                    dq.addFirst(idx);
                }
            }
        }
        n = queries.length;
        int[] res = new int[n];

        for (int i = 0; i < n; i++) {
            res[i] = f.get(queries[i]);
        }

        return res;
    }

}
