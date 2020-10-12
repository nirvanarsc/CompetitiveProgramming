package leetcode.weekly_contests.weekly_128;

import java.util.ArrayList;
import java.util.List;

public class P_1012 {

    public int numDupDigitsAtMostN(int N) {
        final List<Integer> nums = new ArrayList<>();
        for (int x = N + 1; x > 0; x /= 10) {
            nums.add(0, x % 10);
        }

        int countInvalid = 0;
        final int n = nums.size();
        for (int i = 0; i < n - 1; i++) {
            countInvalid += 9 * permutation(9, i);
        }
        final boolean[] isOccupied = new boolean[10];

        for (int i = 0; i < n; i++) {
            final int digit = nums.get(i);
            for (int j = i == 0 ? 1 : 0; j < digit; j++) {
                if (!isOccupied[j]) {
                    countInvalid += permutation(10 - (i + 1), n - i - 1);
                }
            }
            if (isOccupied[digit]) {
                break;
            }
            isOccupied[digit] = true;
        }
        return N - countInvalid;
    }

    private static int permutation(int n, int c) {
        int ans = 1;
        for (int i = 0; i < c; i++, n--) {
            ans *= n;
        }
        return ans;
    }
}
