package leetcode.weekly_contests.weekly_231;

public class P_1785 {

    public int minElements(int[] nums, int limit, int goal) {
        long curr = 0;
        for (int num : nums) {
            curr += num;
        }
        final long diff = Math.abs(goal - curr);
        return (int) ((diff + limit - 1) / limit);
    }
}
