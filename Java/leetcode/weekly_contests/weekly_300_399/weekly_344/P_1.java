package leetcode.weekly_contests.weekly_300_399.weekly_344;

public class P_1 {

    public int[] distinctDifferenceArray(int[] nums) {
        final int[] l = new int[55];
        final int[] r = new int[55];
        int lSize = 0;
        int rSize = 0;
        for (int num : nums) {
            rSize += add(r, num);
        }
        final int n = nums.length;
        final int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            lSize += add(l, nums[i]);
            rSize -= remove(r, nums[i]);
            res[i] = lSize - rSize;
        }
        return res;
    }

    private static int add(int[] set, int v) {
        return ++set[v] == 1 ? 1 : 0;
    }

    private static int remove(int[] set, int v) {
        return --set[v] == 0 ? 1 : 0;
    }
}
