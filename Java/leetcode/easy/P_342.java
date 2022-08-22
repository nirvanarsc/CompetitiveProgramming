package leetcode.easy;

public class P_342 {

    //0x55555555 = 1010101010101010101010101010101
    //to make sure that the single 1 bit always appears at odd indices
    public boolean isPowerOfFour(int n) {
        return n > 0 && (n & (n - 1)) == 0 && (n & 0x55555555) != 0;
    }
}
