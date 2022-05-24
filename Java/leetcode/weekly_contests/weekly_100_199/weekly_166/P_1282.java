package leetcode.weekly_contests.weekly_100_199.weekly_166;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public final class P_1282 {

    public static List<List<Integer>> groupThePeople(int[] groupSizes) {
        final Map<Integer, List<Integer>> map = new HashMap<>();
        final List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < groupSizes.length; i++) {
            if (map.containsKey(groupSizes[i])) {
                map.get(groupSizes[i]).add(i);
            } else {
                map.put(groupSizes[i], new ArrayList<>(Collections.singletonList(i)));
            }
        }

        for (Entry<Integer, List<Integer>> e : map.entrySet()) {
            final List<Integer> ids = e.getValue();
            final Integer size = e.getKey();
            for (int n = 0; n < ids.size(); n += size) {
                res.add(ids.subList(n, n + size));
            }
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(groupThePeople(new int[] { 3, 3, 3, 3, 3, 1, 3 }));
        System.out.println(groupThePeople(new int[] { 2, 1, 3, 3, 3, 2 }));
    }

    private P_1282() {}
}
