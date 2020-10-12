package leetcode.medium;

public class P_365 {

    public int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public boolean canMeasureWater(int x, int y, int z) {
        if (x + y < z) {
            return false;
        }
        if (x == z || y == z || x + y == z) {
            return true;
        }
        return z % gcd(x, y) == 0;
    }
}
