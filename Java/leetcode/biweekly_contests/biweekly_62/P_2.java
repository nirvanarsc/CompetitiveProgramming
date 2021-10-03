package leetcode.biweekly_contests.biweekly_62;

public class P_2 {

    public int numOfPairs(String[] nums, String target) {
        final int n = nums.length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    if ((nums[i] + nums[j]).equals(target)) {
                        res++;
                    }
                }
            }
        }
        return res;
    }
}
