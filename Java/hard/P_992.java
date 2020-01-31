package hard;

public class P_992 {

    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums, k - 1);
    }

    public int atMost(int[] nums, int k) {
        int res = 0, i = 0;
        final int n = nums.length;
        final int[] freq = new int[n + 1];
        for (int j = 0; j < n; j++) {
            k -= freq[nums[j]]++ == 0 ? 1 : 0;
            while (k < 0) {
                k += freq[nums[i++]]-- == 1 ? 1 : 0;
            }
            res += j - i + 1;
        }
        return res;
    }
}
