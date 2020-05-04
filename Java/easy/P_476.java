package easy;

public class P_476 {

    public int findComplement(int num) {
        final int i = Integer.numberOfLeadingZeros(num);
        final int t = num << i;
        return ~t >> i;
    }

    public static int findComplement2(int num) {
        return num ^ ((Integer.highestOneBit(num) << 1) - 1);
    }

    public static int findComplement3(int num) {
        return ~num & (Integer.highestOneBit(num) - 1);
    }
}
