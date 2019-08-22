import java.util.stream.IntStream;

public final class BinaryGap {

    public static void main(String[] args) {
        IntStream.rangeClosed(1, 10).forEach(i -> System.out.println(i + "\t" + binaryGap(i)));
    }

    public static int binaryGap(int n) {
        int prev = -1;
        int res = 0;
        for (int i = 1; n > 0; n >>= 1, i++) {
            if ((n & 1) == 1) {
                if (prev != -1) {
                    res = Math.max(i - prev, res);
                }
                prev = i;
            }
        }

        return res;
    }

    private BinaryGap() {}
}
