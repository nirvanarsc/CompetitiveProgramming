package leetcode.medium;

import java.util.Arrays;

public class P_165 {

    public int compareVersion(String version1, String version2) {
        final int[] left = Arrays.stream(version1.split("\\.")).mapToInt(Integer::valueOf).toArray();
        final int[] right = Arrays.stream(version2.split("\\.")).mapToInt(Integer::valueOf).toArray();
        for (int i = 0; i < Math.max(left.length, right.length); i++) {
            final int l = i >= left.length ? 0 : left[i];
            final int r = i >= right.length ? 0 : right[i];
            if (l > r) {
                return 1;
            }
            if (l < r) {
                return -1;
            }
        }
        return 0;
    }
}
