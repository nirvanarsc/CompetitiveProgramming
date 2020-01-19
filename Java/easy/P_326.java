package easy;

public class P_326 {

    public boolean isPowerOfThree(int n) {
        return n > 0 && getMaxPowerOfThree() % n == 0;
    }

    private static int getMaxPowerOfThree() {
        int i = 3;
        while (i * 3 > i) {
            i *= 3;
        }
        return i;
    }
}
