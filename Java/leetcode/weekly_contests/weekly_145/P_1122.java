package leetcode.weekly_contests.weekly_145;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class P_1122 {

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        final Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr2.length; i++) {
            map.put(arr2[i], i);
        }
        return Arrays.stream(arr1)
                     .boxed()
                     .sorted((a, b) -> {
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

                     })
                     .mapToInt(i -> i)
                     .toArray();
    }

    public int[] relativeSortArrayBucketSort(int[] arr1, int[] arr2) {
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
