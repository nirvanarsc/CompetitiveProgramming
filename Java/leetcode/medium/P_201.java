package leetcode.medium;

public class P_201 {

    public int rangeBitwiseAndOld(int m, int n) {
        int c = 0;
        while (m != n) {
            m >>= 1;
            n >>= 1;
            c++;
        }
        return m << c;
    }

    public int rangeBitwiseAndBC(int m, int n) {
        while (m < n) {
            n &= n - 1;
        }
        return m & n;
    }

    public int rangeBitwiseAnd(int left, int right) {
        int res = 0;
        for (int shift = 31; shift >= 0 && (left & (1 << shift)) == (right & (1 << shift)); shift--) {
            if ((left & (1 << shift)) != 0) {
                res |= 1 << shift;
            }
        }
        return res;
    }
}
