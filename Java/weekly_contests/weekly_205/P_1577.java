package weekly_contests.weekly_205;

import java.util.HashMap;
import java.util.Map;

public class P_1577 {

    public int numTriplets(int[] nums1, int[] nums2) {
        final Map<Long, Integer> squares1 = new HashMap<>();
        final Map<Long, Integer> squares2 = new HashMap<>();
        for (int num : nums1) {
            squares1.merge((long) num * num, 1, Integer::sum);
        }
        for (int num : nums2) {
            squares2.merge((long) num * num, 1, Integer::sum);
        }
        int res = 0;
        for (int i = 0; i < nums1.length; i++) {
            for (int j = i + 1; j < nums1.length; j++) {
                res += squares2.getOrDefault((long) nums1[i] * nums1[j], 0);
            }
        }
        for (int i = 0; i < nums2.length; i++) {
            for (int j = i + 1; j < nums2.length; j++) {
                res += squares1.getOrDefault((long) nums2[i] * nums2[j], 0);
            }
        }
        return res;
    }

    public int numTripletsTwoSum(int[] nums1, int[] nums2) {
        final Map<Long, Integer> squares1 = new HashMap<>();
        final Map<Long, Integer> squares2 = new HashMap<>();
        for (long num : nums1) {
            squares1.merge(num * num, 1, Integer::sum);
        }
        for (long num : nums2) {
            squares2.merge(num * num, 1, Integer::sum);
        }
        int res = 0;
        for (Map.Entry<Long, Integer> e : squares1.entrySet()) {
            res += e.getValue() * twoProduct(e.getKey(), nums2);
        }
        for (Map.Entry<Long, Integer> e : squares2.entrySet()) {
            res += e.getValue() * twoProduct(e.getKey(), nums1);
        }
        return res;
    }

    private static int twoProduct(long target, int[] arr) {
        final Map<Long, Integer> map = new HashMap<>();
        int res = 0;
        for (long v : arr) {
            if (target % v == 0) {
                res += map.getOrDefault(target / v, 0);
            }
            map.merge(v, 1, Integer::sum);
        }
        return res;
    }
}
