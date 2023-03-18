package leetcode.biweekly_contests.biweekly_0_99.biweekly_9;

import java.util.Arrays;

public class P_1198 {

    public int smallestCommonElement(int[][] mat) {
        boolean found;
        for (int num : mat[0]) {
            found = true;
            for (int k = 1; k < mat.length; k++) {
                if (Arrays.binarySearch(mat[k], num) < 0) {
                    found = false;
                    break;
                }
            }
            if (found) { return num; }
        }
        return -1;
    }
}
