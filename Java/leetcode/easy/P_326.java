package leetcode.easy;

public class P_326 {

    public boolean isPowerOfThree(int n) {
        // 3^18 = 1162261467
        return n > 0 && 1162261467 % n == 0;
    }
}
