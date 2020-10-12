package leetcode.hard;

public class P_330 {

    public int minPatches(int[] nums, int n) {
        int patches = 0, i = 0;
        long miss = 1;
        while (miss <= n) {
            if (i < nums.length && nums[i] <= miss) {
                miss += nums[i++];
            } else {
                miss += miss;
                patches++;
            }
        }
        return patches;
    }
}
