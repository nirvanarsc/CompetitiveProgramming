import java.util.Arrays;

public final class ReshapeMatrix {

    public static void main(String[] args) {
        for (int[] i : matrixReshape(new int[][] { { 1, 2, 3, 4, 5, 6 } }, 3, 2)) {
            System.out.println(Arrays.toString(i));
        }
        for (int[] i : matrixReshape2(new int[][] { { 1, 2, 3, 4, 5, 6 } }, 3, 2)) {
            System.out.println(Arrays.toString(i));
        }
    }

    public static int[][] matrixReshape(int[][] nums, int r, int c) {
        if (nums.length * nums[0].length != r * c) { return nums; }

        final int[][] reshaped = new int[r][c];
        int currRow = 0, currCol = 0;
        for (int[] num : nums) {
            for (int value : num) {
                if (currCol == c) {
                    currCol = 0;
                    currRow++;
                }
                reshaped[currRow][currCol++] = value;
            }
        }

        return reshaped;
    }

    public static int[][] matrixReshape2(int[][] nums, int r, int c) {
        final int m = nums.length;
        final int n = nums[0].length;
        if (r * c != m * n) { return nums; }

        final int[][] reshaped = new int[r][c];
        for (int i = 0; i < r * c; i++) {
            reshaped[i / c][i % c] = nums[i / n][i % n];
        }
        return reshaped;
    }

    private ReshapeMatrix() {}
}
