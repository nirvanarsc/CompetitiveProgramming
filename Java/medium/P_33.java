package medium;

public final class P_33 {

    public static int search(int[] nums, int target) {
        int low = findSmallest(nums);
        int high = low + nums.length - 1;

        while (low <= high) {
            final int mid = low + high >>> 1;
            if (nums[mid % nums.length] == target) {
                return mid % nums.length;
            } else if (nums[mid % nums.length] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }

    private static int findSmallest(int[] nums) {
        int low = 0, high = nums.length - 1;

        while (low < high) {
            final int mid = low + high >>> 1;
            if (nums[mid] > nums[high]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }

    public static void main(String[] args) {
        System.out.println(search(new int[] { 4, 5, 6, 7, 0, 1, 2 }, 0));
        System.out.println(search(new int[] { 4, 5, 6, 7, 0, 1, 2 }, 3));
        System.out.println(search(new int[] { 1 }, 1));
    }

    private P_33() {}
}
