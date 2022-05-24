package leetcode.weekly_contests.weekly_200_299.weekly_286;

public class P_2 {

    public int minDeletion(int[] nums) {
        int res = 0;
        int prev = -1;
        int idx = 0;
        for (int num : nums) {
            if (idx % 2 != 0) {
                if (prev == num) {
                    res++;
                } else {
                    idx++;
                    prev = num;
                }
            } else {
                idx++;
                prev = num;
            }
        }
        return res + idx % 2;
    }
}
