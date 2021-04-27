package binarysearch.weekly_48;

public class P_2 {

    public String[][] solve(String[][] matrix) {
        final int n = matrix.length;
        final int m = matrix[0].length;
        final String[][] res = new String[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = n - 1; j >= 0; j--) {
                res[i][n - 1 - j] = matrix[j][i];
            }
        }
        for (int i = 0; i < n; i++) {
            int j = 0;
            while (j < m) {
                int count = 0;
                int k = j;
                while (k < m && res[k][i].charAt(0) != '*') {
                    count += res[k][i].charAt(0) == '#' ? 1 : 0;
                    res[k][i] = ".";
                    k++;
                }
                for (int l = k - 1; count > 0; l--) {
                    res[l][i] = "#";
                    count--;
                }
                j = k + 1;
            }
        }
        return res;
    }
}
