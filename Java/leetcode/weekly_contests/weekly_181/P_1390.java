package leetcode.weekly_contests.weekly_181;

import java.util.HashSet;
import java.util.Set;

public class P_1390 {

    static class Pair {
        int sum;
        boolean isValid;

        Pair(int sum, boolean isValid) {
            this.sum = sum;
            this.isValid = isValid;
        }
    }

    public int sumFourDivisors(int[] nums) {
        int res = 0;
        for (int num : nums) {
            final Pair pair = has4Div(num);
            if (pair.isValid) {
                res += pair.sum;
            }
        }
        return res;
    }

    private static Pair has4Div(int num) {
        final int sqrt = (int) Math.sqrt(num);
        if (sqrt * sqrt == num) {
            return new Pair(-1, false);
        }
        final Set<Integer> set = new HashSet<>();
        for (int i = 1; i <= sqrt; i++) {
            if (num % i == 0) {
                set.add(i);
                set.add(num / i);
            }
            if (set.size() > 4) {
                return new Pair(-1, false);
            }
        }
        if (set.size() == 4) {
            int sum = 0;
            for (int i : set) {
                sum += i;
            }
            return new Pair(sum, true);
        }
        return new Pair(-1, false);
    }
}
