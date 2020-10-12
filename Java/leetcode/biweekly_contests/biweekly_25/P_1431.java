package leetcode.biweekly_contests.biweekly_25;

import java.util.ArrayList;
import java.util.List;

public class P_1431 {

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = 0;
        for (int c : candies) {
            max = Math.max(max, c);
        }
        final List<Boolean> res = new ArrayList<>();
        for (int c : candies) {
            res.add(c + extraCandies >= max);
        }
        return res;
    }
}
