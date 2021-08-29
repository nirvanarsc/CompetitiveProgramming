package leetcode.weekly_contests.weekly_256;

import java.util.Arrays;

public class P_2 {

    public String kthLargestNumber(String[] nums, int k) {
        Arrays.sort(nums, (a, b) -> a.length() == b.length() ? a.compareTo(b) :
                                    Integer.compare(a.length(), b.length()));
        return nums[nums.length - k];
    }
}
