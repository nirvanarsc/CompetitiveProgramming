package hard;

public final class P_154 {

    public static int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        while (low < high) {
            final int mid = low + high >>> 1;
            if (nums[mid] == nums[high]) {
                high--;
            } else if (nums[mid] > nums[high]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return nums[low];
    }

    public static void main(String[] args) {
        System.out.println(findMin(new int[] { 2, 2, 2, 0, 1 }));
        System.out.println(findMin(new int[] { 1, 3, 5 }));
        System.out.println(findMin(new int[] { 1, 3, 3 }));
    }

    private P_154() {}
}
