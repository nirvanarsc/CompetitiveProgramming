package leetcode.medium;

import java.util.List;

public class P_1428 {

    interface BinaryMatrix {
        int get(int x, int y);

        List<Integer> dimensions();
    }

    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        final List<Integer> dimensions = binaryMatrix.dimensions();
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < dimensions.get(0); i++) {
            final int currRow = bs(binaryMatrix, dimensions.get(1), i);
            if (currRow != -1) {
                res = Math.min(res, currRow);
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    private static int bs(BinaryMatrix binaryMatrix, int colSize, int currRow) {
        int lo = 0;
        int hi = colSize;
        while (lo < hi) {
            final int mid = lo + hi >>> 1;
            if (binaryMatrix.get(currRow, mid) == 0) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo == colSize ? -1 : lo;
    }
}
