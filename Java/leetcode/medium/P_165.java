package leetcode.medium;

import java.util.Arrays;

public class P_165 {

    public int compareVersion(String version1, String version2) {
        final int[] left = Arrays.stream(version1.split("\\.")).mapToInt(Integer::valueOf).toArray();
        final int[] right = Arrays.stream(version2.split("\\.")).mapToInt(Integer::valueOf).toArray();
        final int n = left.length;
        final int m = right.length;
        for (int i = 0; i < Math.max(n, m); i++) {
            final int l = i >= n ? 0 : left[i];
            final int r = i >= m ? 0 : right[i];
            if (l > r) {
                return 1;
            } else if (l < r) {
                return -1;
            }
        }
        return 0;
    }
}
