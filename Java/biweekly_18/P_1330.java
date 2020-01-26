package biweekly_18;

public class P_1330 {

    public int maxValueAfterReverse(int[] nums) {
        int total = 0;
        int res = 0;
        int min = (int) 1e9;
        int max = (int) -1e9;
        final int n = nums.length;
        for (int i = 0; i < n - 1; ++i) {
            final int a = nums[i];
            final int b = nums[i + 1];
            total += Math.abs(a - b);
            res = Math.max(res, Math.abs(nums[0] - b) - Math.abs(a - b));
            res = Math.max(res, Math.abs(nums[n - 1] - a) - Math.abs(a - b));
            min = Math.min(min, Math.max(a, b));
            max = Math.max(max, Math.min(a, b));
        }
        return total + Math.max(res, (max - min) * 2);
    }
}
