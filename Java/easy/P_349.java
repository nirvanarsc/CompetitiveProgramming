package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P_349 {

    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        final List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums2.length; i++) {
            if (i > 0 && nums2[i] == nums2[i - 1]) {
                continue;
            }
            if (Arrays.binarySearch(nums1, nums2[i]) >= 0) {
                res.add(nums2[i]);
            }
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}
