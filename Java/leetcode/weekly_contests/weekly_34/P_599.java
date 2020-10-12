package leetcode.weekly_contests.weekly_34;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P_599 {

    public String[] findRestaurant(String[] list1, String[] list2) {
        final Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }
        List<String> res = new ArrayList<>();
        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < list2.length; i++) {
            if (map.containsKey(list2[i])) {
                if (minDiff > map.get(list2[i]) + i) {
                    minDiff = map.get(list2[i]) + i;
                    res = new ArrayList<>(Collections.singleton(list2[i]));
                } else if (minDiff == map.get(list2[i]) + i) {
                    res.add(list2[i]);
                }
            }
        }
        return res.toArray(String[]::new);
    }
}
