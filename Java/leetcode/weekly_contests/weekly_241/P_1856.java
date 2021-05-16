package leetcode.weekly_contests.weekly_241;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings({ "InnerClassMayBeStatic", "unused" })
public class P_1856 {

    class FindSumPairs {

        Map<Integer, Integer> map = new HashMap<>();
        int[] l;
        int[] r;

        FindSumPairs(int[] nums1, int[] nums2) {
            l = nums1;
            r = nums2;
            for (int num : nums2) {
                map.merge(num, 1, Integer::sum);
            }
        }

        public void add(int index, int val) {
            final int curr = r[index];
            if (map.merge(curr, -1, Integer::sum) == 0) {
                map.remove(curr);
            }
            map.merge(curr + val, 1, Integer::sum);
            r[index] += val;
        }

        public int count(int tot) {
            int res = 0;
            for (int num : l) {
                res += map.getOrDefault(tot - num, 0);
            }
            return res;
        }
    }
}
