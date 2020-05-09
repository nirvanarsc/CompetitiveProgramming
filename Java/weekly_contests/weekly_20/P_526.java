package weekly_contests.weekly_20;

import java.util.stream.IntStream;

@SuppressWarnings("MethodParameterNamingConvention")
public class P_526 {

    public int countArrangement(int N) {
        final int[] nums = IntStream.rangeClosed(1, N).toArray();
        final int[] res = { 0 };
        permute(nums, nums.length - 1, res);
        return res[0];
    }

    private void permute(int[] arr, int idx, int[] res) {
        if (idx == 0) {
            res[0]++;
        }
        for (int i = idx; i >= 0; i--) {
            swap(arr, idx, i);
            if (arr[idx] % (idx + 1) == 0 || (idx + 1) % arr[idx] == 0) {
                permute(arr, idx - 1, res);
            }
            swap(arr, i, idx);
        }
    }

    public void swap(int[] nums, int x, int y) {
        final int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
}
