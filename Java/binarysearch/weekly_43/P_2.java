package binarysearch.weekly_43;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class P_2 {

    public boolean solve(int[] nums) {
        if (nums.length < 2) {
            return true;
        }
        final List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
        return solve(list);
    }

    private static boolean solve(List<Integer> list) {
        int idx = -1;
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) > list.get(i + 1)) {
                idx = i;
                break;
            }
        }
        if (idx != -1) {
            int L = idx;
            int R = idx;
            while (L > 0 && list.get(L - 1) >= list.get(L)) { L--; }
            while (R < (list.size() - 1) && list.get(R) >= list.get(R + 1)) { R++; }
            Collections.reverse(list.subList(L, R + 1));
            for (int i = 0; i < list.size() - 1; i++) {
                if (list.get(i) > list.get(i + 1)) {
                    return false;
                }
            }
            return true;
        }
        return true;
    }

}
