package leetcode.weekly_contests.weekly_22;

import java.util.HashMap;
import java.util.Map;

public class P_533 {

    @SuppressWarnings("MethodParameterNamingConvention")
    public int findBlackPixel(char[][] picture, int N) {
        final int n = picture.length;
        final int m = picture[0].length;
        final int[] cols = new int[m];
        final Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            final String key = scanRow(picture, i, N, cols);
            if (!key.isEmpty()) {
                map.merge(key, 1, Integer::sum);
            }
        }
        int result = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() == N) {
                for (int j = 0; j < m; j++) {
                    if (entry.getKey().charAt(j) == 'B' && cols[j] == N) {
                        result += N;
                    }
                }
            }
        }
        return result;
    }

    private static String scanRow(char[][] picture, int row, int target, int[] colCount) {
        final int n = picture[0].length;
        int rowCount = 0;
        final StringBuilder sb = new StringBuilder();
        for (int j = 0; j < n; j++) {
            if (picture[row][j] == 'B') {
                rowCount++;
                colCount[j]++;
            }
            sb.append(picture[row][j]);
        }
        return rowCount == target ? sb.toString() : "";
    }
}
