package leetcode.weekly_contests.weekly_0_99.weekly_35;

public class P_605 {

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        final int m = flowerbed.length;
        int res = 0;
        for (int i = 0; i < m; i++) {
            if (flowerbed[i] == 1) {
                if (i > 0) {
                    flowerbed[i - 1] = 2;
                }
                if (i < (m - 1)) {
                    flowerbed[i + 1] = 2;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            if (flowerbed[i] == 0) {
                int j = i;
                while (j < m && flowerbed[j] == 0) {
                    j++;
                }
                res += (j - i + 1) / 2;
                i = j - 1;
            }
        }
        return res >= n;
    }
}
