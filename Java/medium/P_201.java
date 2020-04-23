package medium;

public class P_201 {

    public int rangeBitwiseAnd(int m, int n) {
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
}
