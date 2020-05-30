import hard.P_84;

public final class MaximalRectangle {

    public static int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        final int m = matrix[0].length;
        final int[] currRow = new int[m];
        int res = 0;
        for (char[] row : matrix) {
            for (int i = 0; i < m; i++) {
                if (row[i] == '1') {
                    currRow[i]++;
                } else {
                    currRow[i] = 0;
                }
            }
            res = Math.max(res, P_84.largestRectangleArea(currRow));
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(maximalRectangle(new char[][] {
                { '1', '0', '1', '0', '0' },
                { '1', '0', '1', '1', '1' },
                { '1', '1', '1', '1', '1' },
                { '0', '0', '0', '1', '0' },
                }));
    }

    private MaximalRectangle() {}
}
