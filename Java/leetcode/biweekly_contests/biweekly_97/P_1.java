package leetcode.biweekly_contests.biweekly_97;

import java.util.ArrayList;
import java.util.List;

public class P_1 {

    public int[] separateDigits(int[] nums) {
        final List<Integer> res = new ArrayList<>();
        for (int num : nums) {
            final String str = String.valueOf(num);
            for (char c : str.toCharArray()) {
                res.add(c - '0');
            }
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}
