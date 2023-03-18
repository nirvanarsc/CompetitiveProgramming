package leetcode.biweekly_contests.biweekly_0_99.biweekly_38;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class P_1636 {

    public int[] frequencySort(int[] nums) {
        final Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.merge(num, 1, Integer::sum);
        }
        return Arrays.stream(nums)
                     .boxed()
                     .sorted((a, b) -> freq.get(a).equals(freq.get(b))
                                       ? Integer.compare(b, a)
                                       : Integer.compare(freq.get(a), freq.get(b)))
                     .mapToInt(Integer::intValue)
                     .toArray();
    }
}
