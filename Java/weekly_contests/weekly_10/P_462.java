package weekly_contests.weekly_10;

import static utils.NthElement.findKthLargest;

public class P_462 {

    public int minMoves2(int[] nums) {
        final int mid = nums.length / 2 + nums.length % 2;
        return cost(nums, findKthLargest(nums, mid));
    }

    private static int cost(int[] nums, int mid) {
        int res = 0;
        for (int num : nums) {
            res += Math.abs(mid - num);
        }
        return res;
    }
}
