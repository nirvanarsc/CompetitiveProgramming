package leetcode.weekly_contests.weekly_300_399.weekly_315;

public class P_1 {

    public int findMaxK(int[] nums) {
        final int[] l = new int[1005];
        final int[] r = new int[1005];
        for (int num : nums) {
            if (num < 0) {
                l[-num]++;
            } else {
                r[num]++;
            }
        }
        for (int i = 1000; i >= 1; i--) {
            if (l[i] > 0 && r[i] > 0) {
                return i;
            }
        }
        return -1;
    }
}
