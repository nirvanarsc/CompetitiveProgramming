package medium;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("MethodParameterNamingConvention")
public class P_311 {

    public int[][] multiply(int[][] A, int[][] B) {
        final int aRow = A.length;
        final int aCol = A[0].length;
        final int bCol = B[0].length;
        final int[][] C = new int[aRow][bCol];

        for (int i = 0; i < aRow; i++) {
            for (int k = 0; k < aCol; k++) {
                if (A[i][k] != 0) {
                    for (int j = 0; j < bCol; j++) {
                        C[i][j] += A[i][k] * B[k][j];
                    }
                }
            }
        }
        return C;
    }

    public int[][] sparseMatrixMultiplication(int[][] A, int[][] B) {
        final int aRow = A.length;
        final int aCol = A[0].length;
        final int bCol = B[0].length;
        final int[][] C = new int[aRow][bCol];
        final Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        for (int i = 0; i < aRow; i++) {
            final Map<Integer, Integer> temp = new HashMap<>();
            for (int j = 0; j < aCol; j++) {
                if (A[i][j] != 0) {
                    temp.put(j, A[i][j]);
                }
            }
            map.put(i, temp);
        }
        for (Map.Entry<Integer, Map<Integer, Integer>> entry : map.entrySet()) {
            for (int j = 0; j < bCol; j++) {
                for (int key2 : entry.getValue().keySet()) {
                    C[entry.getKey()][j] += entry.getValue().get(key2) * B[key2][j];
                }
            }
        }
        return C;
    }
}
