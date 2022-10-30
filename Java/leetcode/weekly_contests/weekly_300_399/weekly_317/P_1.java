package leetcode.weekly_contests.weekly_300_399.weekly_317;

public class P_1 {

    public int averageValue(int[] nums) {
        int count = 0;
        int sum = 0;
        for (int num : nums) {
            if (num % 6 == 0) {
                sum += num;
                count++;
            }
        }
        return count == 0 ? 0 : sum / count;
    }
}
