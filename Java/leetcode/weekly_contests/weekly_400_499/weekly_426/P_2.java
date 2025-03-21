package leetcode.weekly_contests.weekly_400_499.weekly_426;

public class P_2 {

    public int getLargestOutlier(int[] nums) {
        int res = (int) -1e3;
        int sum = 0;
        final int[] seen = new int[(int) (2e3 + 5)];
        for (int num : nums) {
            seen[num + (int) 1e3]++;
            sum += num;
        }
        for (int num : nums) {
            if ((sum - num) % 2 == 0) {
                final int abc = (sum - num) / 2;
                final int abcOffset = abc + (int) 1e3;
                if (0 <= abcOffset && abcOffset < seen.length) {
                    if (seen[abcOffset] > 1 || (seen[abcOffset] == 1 && abc != num)) {
                        res = Math.max(res, num);
                    }
                }
            }
        }
        return res;
    }
}
