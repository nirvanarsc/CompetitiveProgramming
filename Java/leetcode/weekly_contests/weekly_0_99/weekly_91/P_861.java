package leetcode.weekly_contests.weekly_0_99.weekly_91;

public class P_861 {

    public int matrixScore(int[][] mat) {
        final int n = mat.length;
        final int m = mat[0].length;
        int ans = 0;
        for (int col = 0; col < m; ++col) {
            int curr = 0;
            for (int[] ints : mat) {
                curr += ints[col] ^ ints[0];
            }
            ans += Math.max(curr, n - curr) * (1 << (m - 1 - col));
        }
        return ans;
    }

    public int matrixScoreBF(int[][] mat) {
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
        final StringBuilder sb = new StringBuilder();
        int res = 0;
        for (int[] row : mat) {
            for (int i : row) {
                sb.append(i);
            }
            res += Integer.parseInt(sb.toString(), 2);
            sb.setLength(0);
        }
        return res;
    }
}
