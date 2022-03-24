package leetcode.weekly_contests.weekly_96;

import java.util.Arrays;

public class P_881 {

    public int numRescueBoats(int[] people, int limit) {
        final int n = people.length;
        Arrays.sort(people);
        int res = n;
        int l = 0;
        int r = n - 1;
        while (l < r) {
            if (people[l] + people[r] <= limit) {
                res--;
                l++;
            }
            r--;
        }
        return res;
    }
}
