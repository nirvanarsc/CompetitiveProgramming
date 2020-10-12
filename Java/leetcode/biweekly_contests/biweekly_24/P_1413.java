package leetcode.biweekly_contests.biweekly_24;

public class P_1413 {

    public int minStartValue(int[] nums) {
        int min = 0;
        int sum = 0;
        for (int num : nums) {
            sum += num;
            min = Math.min(min, sum);
        }
        return -min + 1;
    }
}
