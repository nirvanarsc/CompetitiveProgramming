package binarysearch.weekly_54;

public class P_3 {

    public int solve(int n, int[][] requests) {
        final int[][] mat = new int[2][n];
        int res = 0;
        int freeCols = n;
        int crossBlocks = 0;
        for (int[] request : requests) {
            final int row = request[0];
            final int col = request[1];
            final int type = request[2];
            if (type == 0) {
                if (mat[row][col] == 1) {
                    mat[row][col] = 0;
                    if (mat[1 - row][col] == 1) {
                        freeCols++;
                    }
                    if (col > 0 && mat[1 - row][col - 1] == 1) {
                        crossBlocks--;
                    }
                    if (col < (n - 1) && mat[1 - row][col + 1] == 1) {
                        crossBlocks--;
                    }
                }
            } else {
                if (mat[row][col] == 0) {
                    mat[row][col] = 1;
                    if (mat[1 - row][col] == 1) {
                        freeCols--;
                    }
                    if (col > 0 && mat[1 - row][col - 1] == 1) {
                        crossBlocks++;
                    }
                    if (col < (n - 1) && mat[1 - row][col + 1] == 1) {
                        crossBlocks++;
                    }
                }
            }
            if (freeCols == n && crossBlocks == 0) {
                res++;
            }
        }
        return res;
    }
}
