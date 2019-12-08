package medium;

public final class P_861 {

    public static int matrixScore(int[][] mat) {
        for (int[] row : mat) {
            if (row[0] == 0) {
                flipRow(row);
            }
        }
        for (int col = 0; col < mat[0].length; col++) {
            int curr = 0;
            for (int[] ints : mat) {
                if (ints[col] == 0) {
                    curr++;
                }
            }
            if (curr > mat.length / 2) {
                flipCol(mat, col);
            }
        }

        return hashState(mat);
    }

    private static void flipRow(int[] row) {
        for (int i = 0; i < row.length; i++) {
            row[i] ^= 1;
        }
    }

    private static void flipCol(int[][] mat, int col) {
        for (int i = 0; i < mat.length; i++) {
            mat[i][col] ^= 1;
        }
    }

    private static int hashState(int[][] mat) {
        int res = 0;
        for (int[] row : mat) {
            int num = 0;
            for (int i = 0; i < row.length; i++) {
                num |= row[i] << row.length - 1 - i;
            }
            res += num;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(matrixScore(new int[][] { { 0, 0, 1, 1 }, { 1, 0, 1, 0 }, { 1, 1, 0, 0 } }));
    }

    private P_861() {}
}
