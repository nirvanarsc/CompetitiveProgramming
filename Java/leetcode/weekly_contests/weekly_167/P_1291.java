package leetcode.weekly_contests.weekly_167;

import java.util.ArrayList;
import java.util.List;

public class P_1291 {

    public List<Integer> sequentialDigitsBF(int low, int high) {
        final int[] allNums = {
                12, 23, 34, 45, 56, 67, 78, 89,
                123, 234, 345, 456, 567, 678, 789,
                1234, 2345, 3456, 4567, 5678, 6789,
                12345, 23456, 34567, 45678, 56789,
                123456, 234567, 345678, 456789,
                1234567, 2345678, 3456789,
                12345678, 23456789,
                123456789
        };
        final List<Integer> res = new ArrayList<>();
        for (int allNum : allNums) {
            if (allNum < low) { continue; }
            if (allNum > high) { break; }
            res.add(allNum);
        }
        return res;
    }

    public List<Integer> sequentialDigits(int low, int high) {
        final String digits = "123456789";
        final List<Integer> res = new ArrayList<>();
        for (int l = 2; l <= 9; l++) {
            for (int i = l; i <= 9; i++) {
                final int curr = Integer.parseInt(digits.substring(i - l, i));
                if (low <= curr && curr <= high) {
                    res.add(curr);
                }
            }
        }
        return res;
    }
}
