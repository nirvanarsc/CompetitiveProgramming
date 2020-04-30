package weekly_contests.weekly_31;

import java.util.HashSet;
import java.util.Set;

public class P_575 {

    public int distributeCandies(int[] candies) {
        final Set<Integer> set = new HashSet<>();
        for (int c : candies) { set.add(c); }
        return Math.max(set.size(), candies.length / 2);
    }
}
