package easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P_1122 {

    public int[] relativeSortArrayCustom(int[] arr1, int[] arr2) {
        final Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr2.length; i++) {
            map.put(arr2[i], i);
        }
        final List<Integer> list = new ArrayList<>();
        for (int i : arr1) {
            list.add(i);
        }
        list.sort((a, b) -> {
            if (map.containsKey(a) && map.containsKey(b)) {
                return Integer.compare(map.get(a), map.get(b));
            }
            if (map.containsKey(a)) {
                return -1;
            }
            if (map.containsKey(b)) {
                return 1;
            }
            return Integer.compare(a, b);
        });
        for (int i = 0; i < list.size(); i++) {
            arr1[i] = list.get(i);
        }
        return arr1;
    }

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        final int max_number = 1001;
        final int[] map = new int[max_number];
        final int[] ans = new int[arr1.length];
        int idx = 0;
        for (int i : arr1) {
            map[i]++;
        }
        for (int i : arr2) {
            while (map[i]-- > 0) {
                ans[idx++] = i;
            }
        }
        for (int i = 0; i < max_number; i++) {
            while (map[i]-- > 0) {
                ans[idx++] = i;
            }
        }
        return ans;
    }
}
