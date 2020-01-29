package medium;

public final class P_287 {

    // Floyd's Cycle Detection Algorithm
    // https://en.wikipedia.org/wiki/Cycle_detection#Floyd's_Tortoise_and_Hare
    public int findDuplicateFloyd(int[] nums) {
        if (nums.length > 1) {
            int slow = nums[0];
            int fast = nums[nums[0]];
            while (slow != fast) {
                slow = nums[slow];
                fast = nums[nums[fast]];
            }

            fast = 0;
            while (fast != slow) {
                fast = nums[fast];
                slow = nums[slow];
            }
            return slow;
        }
        return -1;
    }

    // https://en.wikipedia.org/wiki/Pigeonhole_principle
    // https://en.wikipedia.org/wiki/Peter_Gustav_Lejeune_Dirichlet
    public int findDuplicatePigeonhole(int[] nums) {
        int lo = 1, hi = nums.length;
        while (lo < hi) {
            final int mid = lo + hi >>> 1;
            int count = 0;
            for (int num : nums) {
                if (num <= mid) {
                    count++;
                }
            }
            if (count <= mid) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }

    public int findDuplicateMarkExistingArray(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            final int abs = Math.abs(nums[i]);
            if (nums[abs - 1] < 0) {
                return abs;
            }
            nums[abs - 1] = -nums[abs - 1];
        }
        return -1;
    }
}
