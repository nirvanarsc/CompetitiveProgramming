package leetcode.weekly_contests.weekly_14;

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

    public int findComplement4(int num) {
        int msb = 0;
        for (int i = 31; i >= 0; i--) {
            if ((num & (1 << i)) != 0) {
                msb = i;
                break;
            }
        }
        final int mask = (1 << (msb + 1)) - 1;
        return mask & ~num;
    }
}
