package biweekly_18;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class P_1331 {

    public int[] arrayRankTransform(int[] arr) {
        final Map<Integer, Integer> ranks = new HashMap<>();
        final int[] sorted = arr.clone();
        Arrays.sort(sorted);
        for (int num : sorted) {
            ranks.putIfAbsent(num, ranks.size() + 1);
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = ranks.get(arr[i]);
        }
        return arr;
    }
}
