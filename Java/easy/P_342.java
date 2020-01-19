package easy;

public class P_342 {

    //0x55555555 = 1010101010101010101010101010101
    //to make sure that the single 1 bit always appears at odd indices
    public boolean isPowerOfFour(int num) {
        return num > 0 && (num & (num - 1)) == 0 && (num & 0x55555555) != 0;
    }
}
