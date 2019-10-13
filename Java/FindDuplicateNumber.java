public final class FindDuplicateNumber {

    public static int findDuplicate1(int[] nums) {
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
    public static int findDuplicate2(int[] nums) {
        int low = 1, high = nums.length;
        int mid, count;

        while (low < high) {
            mid = (low + high) / 2;
            count = 0;
            for (int num : nums) { if (num <= mid) { count++; } }
            if (count <= mid) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        final int[] ints = { 18, 13, 14, 17, 9, 19, 7, 17, 4, 6, 17, 5, 11, 10, 2, 15, 8, 12, 16, 17 };
        System.out.println(findDuplicate1(ints));
        System.out.println(findDuplicate2(ints));
    }

    private FindDuplicateNumber() {}
}
