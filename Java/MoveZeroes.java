import java.util.Arrays;

public final class MoveZeroes {

    public static void main(String[] args) {
        final int[] a = { 0, 1, 0, 3, 12 };
        final int[] b = { 0, 1, 0, 3, 12 };

        moveZeroes(a);
        moveZeroes(b);

        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));
    }

    public static void moveZeroes(int[] nums) {
        for (int i = 0, j = 0; i < nums.length && j < nums.length; ) {
            if (nums[i] != 0 && nums[j] == 0) {
                if (j < i) {
                    swap(nums, i, j);
                } else {
                    i++;
                    continue;
                }
            }
            if (nums[j] != 0) {
                j++;
            }
            if (nums[i] == 0) {
                i++;
            }
        }
    }

    public static void moveZeroes2(int[] nums) {
        for (int i = 0, swapIndex = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (i > swapIndex) {
                    nums[swapIndex] = nums[i];
                    nums[i] = 0;
                }

                swapIndex++;
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        arr[i] ^= arr[j];
        arr[j] ^= arr[i];
        arr[i] ^= arr[j];
    }

    private MoveZeroes() {}
}
