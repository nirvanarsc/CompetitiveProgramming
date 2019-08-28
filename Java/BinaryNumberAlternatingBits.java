public final class BinaryNumberAlternatingBits {

    public static boolean hasAlternatingBits(int n) {
        int prev = n & 1;
        n >>= 1;
        while (n > 0) {
            if (prev == (n & 1)) {
                return false;
            }
            prev = n & 1;
            n >>= 1;
        }
        return true;
    }

    public static boolean hasAlternatingBits2(int n) {
        n ^= n >> 1;
        return (n & n + 1) == 0;
    }

    private BinaryNumberAlternatingBits() {}
}
