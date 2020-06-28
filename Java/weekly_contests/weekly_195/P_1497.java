package weekly_contests.weekly_195;

public class P_1497 {

    public boolean canArrange(int[] arr, int k) {
        final int[] remainders = new int[k];
        for (int num : arr) {
            remainders[Math.floorMod(num, k)]++;
        }
        for (int i = 1; i < k; i++) {
            if (remainders[i] != remainders[k - i]) {
                return false;
            }
        }
        return remainders[0] % 2 == 0;
    }
}
