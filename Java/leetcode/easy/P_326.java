package leetcode.easy;

public class P_326 {

    public boolean isPowerOfThree(int n) {
        return n > 0 && getMaxPowerOfThree() % n == 0;
    }

    private static int getMaxPowerOfThree() {
        int p = 3;
        while (p * 3 > p) {
            p *= 3;
        }
        return p;
    }
}
