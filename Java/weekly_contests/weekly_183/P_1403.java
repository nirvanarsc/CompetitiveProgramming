package weekly_contests.weekly_183;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P_1403 {

    public List<Integer> minSubsequence(int[] nums) {
        Arrays.sort(nums);
        int sum = Arrays.stream(nums).sum();
        int opp = 0;
        final List<Integer> res = new ArrayList<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            if (opp > sum) {
                break;
            }
            sum -= nums[i];
            opp += nums[i];
            res.add(nums[i]);
        }
        return res;
    }
}
