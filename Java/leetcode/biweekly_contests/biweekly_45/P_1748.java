package leetcode.biweekly_contests.biweekly_45;

public class P_1748 {

    public int sumOfUnique(int[] nums) {
        final int[] f = new int[105];
        for (int num : nums) {
            f[num]++;
        }
        int res = 0;
        for (int i = 0; i < f.length; i++) {
            if (f[i] == 1) {
                res += i;
            }
        }
        return res;
    }
}
