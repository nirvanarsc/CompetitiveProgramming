package weekly_contests.weekly_149;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class P_1157 {

    static class MajorityChecker {
        int[] arr;
        Map<Integer, List<Integer>> map;

        MajorityChecker(int[] arr) {
            this.arr = arr;
            map = new HashMap<>();
            for (int i = 0; i < arr.length; i++) {
                map.computeIfAbsent(arr[i], v -> new ArrayList<>()).add(i);
            }
        }

        public int query(int left, int right, int threshold) {
            final Random rand = new Random();
            for (int i = 0; i < 15; i++) {
                final int candidate = arr[rand.nextInt(right - left + 1) + left];
                final List<Integer> temp = map.get(candidate);
                if (temp.size() >= threshold) {
                    int low = Collections.binarySearch(temp, left);
                    int high = Collections.binarySearch(temp, right);
                    if (low < 0) {
                        low = -low - 1;
                    }
                    if (high < 0) {
                        high = -high - 1;
                        high--;
                    }
                    if (high - low + 1 >= threshold) {
                        return candidate;
                    }
                }
            }
            return -1;
        }
    }
}
