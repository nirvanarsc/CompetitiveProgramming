package weekly_contests.weekly_35;

public class P_605 {

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int zeroes = 1;
        int res = 0;
        for (int value : flowerbed) {
            if (value == 1) {
                zeroes = 0;
            } else {
                if (++zeroes == 3) {
                    res++;
                    zeroes = 1;
                }
            }
        }
        if (zeroes == 2) { res++; }
        return n <= res;
    }
}
