package leetcode.easy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class P_119 {

    public List<Integer> getRow(int rowIndex) {
        final int[] res = new int[rowIndex + 1];
        res[0] = 1;
        for (int i = 1; i <= rowIndex; i++) {
            for (int k = i; k >= 1; k--) {
                res[k] += res[k - 1];
            }
        }
        return Arrays.stream(res).boxed().collect(Collectors.toList());
    }
}
