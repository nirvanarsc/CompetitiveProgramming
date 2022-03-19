package leetcode.biweekly_contests.biweekly_74;

public class P_1 {

    public boolean divideArray(int[] nums) {
        final int[] f = new int[505];
        for (int num : nums) {
            f[num]++;
        }
        for (int count : f) {
            if (count % 2 != 0) {
                return false;
            }
        }
        return true;
    }
}
