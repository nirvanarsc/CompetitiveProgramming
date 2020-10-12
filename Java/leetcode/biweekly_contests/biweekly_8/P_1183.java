package leetcode.biweekly_contests.biweekly_8;

import java.util.Comparator;
import java.util.PriorityQueue;

public class P_1183 {

    public int maximumNumberOfOnes(int width, int height, int sideLength, int maxOnes) {
        final int[][] sq = new int[sideLength][sideLength];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                sq[i % sideLength][j % sideLength]++;
            }
        }
        final PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int[] row : sq) {
            for (int num : row) {
                pq.add(num);
            }
        }
        int res = 0;
        for (int i = 0; i < maxOnes; i++) {
            res += pq.remove();
        }
        return res;
    }
}
