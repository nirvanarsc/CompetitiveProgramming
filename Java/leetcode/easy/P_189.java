package leetcode.easy;

public class P_189 {
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(0, nums.length - 1, nums);
        reverse(0, k - 1, nums);
        reverse(k, nums.length - 1, nums);
    }

    private static void reverse(int from, int to, int[] arr) {
        for (int i = from; 2 * i < to + from; i++) {
            final int temp = arr[i];
            arr[i] = arr[to + from - i];
            arr[to + from - i] = temp;
        }
    }

//    public void reverse(int[] nums, int start, int end) {
//        while (start < end) {
//            int temp = nums[start];
//            nums[start] = nums[end];
//            nums[end] = temp;
//            start++;
//            end--;
//        }
//    }
}
