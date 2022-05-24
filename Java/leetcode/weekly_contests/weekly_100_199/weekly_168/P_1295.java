package leetcode.weekly_contests.weekly_100_199.weekly_168;

import java.util.NavigableMap;
import java.util.TreeMap;

public final class P_1295 {

    public static boolean isPossibleDivide(int[] nums, int k) {
        if (nums.length % k != 0) {
            return false;
        }

        final NavigableMap<Integer, Integer> treeMap = new TreeMap<>();
        final int times = nums.length / k;

        for (int num : nums) {
            treeMap.merge(num, 1, Integer::sum);
        }

        for (int i = 0; i < times; i++) {
            Integer idx = treeMap.firstEntry().getKey();
            for (int j = 0; j < k; j++) {
                if (!treeMap.containsKey(idx)) {
                    return false;
                }
                if (treeMap.get(idx) == 1) {
                    treeMap.remove(idx);
                } else {
                    treeMap.put(idx, treeMap.get(idx) - 1);
                }
                idx++;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPossibleDivide(new int[] { 1, 2, 3, 3, 4, 4, 5, 6 }, 4));
        System.out.println(isPossibleDivide(new int[] { 3, 2, 1, 2, 3, 4, 3, 4, 5, 9, 10, 11 }, 3));
        System.out.println(isPossibleDivide(new int[] { 3, 3, 2, 2, 1, 1 }, 3));
    }

    private P_1295() {}
}
