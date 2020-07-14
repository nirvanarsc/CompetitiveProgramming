package easy;

public class P_190 {

    public int reverseBitsXor(int n) {
        int start = 0;
        int end = Integer.SIZE - 1;
        while (start < end) {
            if (getBit(n, start) ^ getBit(n, end)) {
                n ^= (1 << start) | (1 << end);
            }
            start++;
            end--;
        }
        return n;
    }

    public boolean getBit(int n, int j) {
        return (n & (1 << j)) != 0;
    }

    public int reverseBits(int n) {
        int res = 0;
        for (int i = Integer.SIZE - 1, j = 0; i >= 0; i--, j++) {
            if ((n & (1 << i)) != 0) {
                res |= 1 << j;
            }
        }
        return res;
    }
}
