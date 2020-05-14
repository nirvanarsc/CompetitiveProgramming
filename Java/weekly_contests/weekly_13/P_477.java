package weekly_contests.weekly_13;

public class P_477 {

    public int totalHammingDistance(int[] nums) {
        int res = 0;
        for (int i = 0; i < Integer.SIZE; i++) {
            int countBits = 0;
            for (int n : nums) {
                if ((n & (1 << i)) != 0) {
                    countBits++;
                }
            }
            res += (nums.length - countBits) * countBits;
        }
        return res;
    }
}
