package leetcode.weekly_contests.weekly_100_199.weekly_102;

import java.util.Arrays;
import java.util.Comparator;

public class P_905 {

    public int[] sortArrayByParity(int[] nums) {
        return Arrays.stream(nums)
                     .boxed()
                     .sorted(Comparator.comparingInt(a -> a % 2))
                     .mapToInt(Integer::intValue)
                     .toArray();
    }
}
