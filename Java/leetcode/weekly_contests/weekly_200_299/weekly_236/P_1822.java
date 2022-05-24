package leetcode.weekly_contests.weekly_200_299.weekly_236;

public class P_1822 {

    public int arraySign(int[] nums) {
        int neg = 0;
        int zero = 0;
        for (int num : nums) {
            if (num < 0) {
                neg++;
            } else if (num == 0) {
                zero++;
            }
        }
        if (zero > 0) {
            return 0;
        }
        return neg % 2 != 0 ? -1 : 1;
    }
}
