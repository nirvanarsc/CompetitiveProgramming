package leetcode.biweekly_contests.biweekly_98;

public class P_3 {

    public int minImpossibleOR(int[] nums) {
        int or = 0;
        int and = 0x7fffffff;
        for (int num : nums) {
            if ((num & (num - 1)) == 0) {
                or |= num;
            }
            and &= num;
        }
        for (int i = 0; i < 32; i++) {
            if ((and & (1 << i)) == 0 && (or & (1 << i)) == 0) {
                return 1 << i;
            }
        }
        return -1;
    }
}
