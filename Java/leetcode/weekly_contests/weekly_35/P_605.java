package leetcode.weekly_contests.weekly_35;

public class P_605 {

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int add = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            if (i == 0 && flowerbed[0] == 0) {
                if (flowerbed.length > 1 && flowerbed[1] == 0) {
                    add++;
                    flowerbed[0] = 1;
                } else if (flowerbed.length == 1) {
                    add++;
                    flowerbed[0] = 1;
                }
            } else if (i == flowerbed.length - 1 && flowerbed[i] == 0) {
                if (flowerbed[i - 1] == 0) {
                    add++;
                    flowerbed[i] = 1;
                }
            } else if (flowerbed[i] == 0) {
                if (flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0) {
                    add++;
                    flowerbed[i] = 1;
                }
            }
        }
        return add >= n;
    }
}
