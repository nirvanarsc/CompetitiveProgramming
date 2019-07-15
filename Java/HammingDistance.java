import org.jetbrains.annotations.Contract;

public class HammingDistance {

    public static void main(String[] args) {
        System.out.println(hammingDistance(1, 4));
        System.out.println(hammingDistance2(1, 4));
    }

    private static int hammingDistance(int x, int y) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            if (isSet(x, i) != isSet(y, i)) {
                res++;
            }
        }
        return res;
    }

    private static int hammingDistance2(int x, int y) {
        return countSetBits(x ^ y);
    }

    private static boolean isSet(int num, int idx) {
        return (num & (1 << idx)) != 0;
    }

    // https://tech.liuchao.me/2016/11/count-bits-of-integer/
    @Contract(pure = true)
    private static int countSetBits(int num) {
        int count = 0;
        while (num != 0) {
            num &= num - 1;
            count++;
        }
        return count;
    }
}
