package leetcode.biweekly_contests.biweekly_12;

import java.util.ArrayList;
import java.util.List;

public class P_1243 {

    public List<Integer> transformArray(int[] arr) {
        boolean hasChange = true;
        while (hasChange) {
            hasChange = false;
            final int[] clone = arr.clone();
            for (int i = 1; i < arr.length - 1; i++) {
                if (arr[i - 1] < arr[i] && arr[i + 1] < arr[i]) {
                    clone[i]--;
                    hasChange = true;
                }
                if (arr[i - 1] > arr[i] && arr[i + 1] > arr[i]) {
                    clone[i]++;
                    hasChange = true;
                }
            }
            arr = clone;
        }
        final List<Integer> res = new ArrayList<>();
        for (int num : arr) {
            res.add(num);
        }
        return res;
    }
}
