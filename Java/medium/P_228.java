package medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class P_228 {

    public List<String> summaryRanges(int[] nums) {
        if (nums.length == 0) {
            return Collections.emptyList();
        }
        final List<String> res = new ArrayList<>();
        int start = nums[0], prev = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != prev + 1) {
                res.add(toString(start, prev));
                start = nums[i];
            }
            prev = nums[i];
        }
        res.add(toString(start, prev));
        return res;
    }

    private static String toString(int start, int end) {
        if (start == end) {
            return String.valueOf(start);
        }
        return start + "->" + end;
    }
}
