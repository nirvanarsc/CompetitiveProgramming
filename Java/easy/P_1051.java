package easy;

import java.util.Arrays;

public class P_1051 {

    public int heightChecker(int[] heights) {
        final int[] copy = Arrays.copyOf(heights, heights.length);
        Arrays.sort(copy);
        int res = 0;
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] != copy[i]) {
                res++;
            }
        }
        return res;
    }
}
