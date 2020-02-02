package medium;

import java.util.Arrays;

public final class P_338 {

    public static int[] countBits(int num) {
        final int[] res = new int[num + 1];
        int pow = 1;
        while (true) {
            for (int i = pow; i < pow << 1; i++) {
                if (i >= res.length) {
                    return res;
                }
                res[i] = res[i - pow] + 1;
            }
            pow <<= 1;
        }
    }

    public static int[] countBits2(int num) {
        final int[] res = new int[num + 1];
        int pow = 1;
        for (int i = 1; i <= num; i++) {
            if (pow << 1 == i) {
                pow <<= 1;
            }
            res[i] = res[i - pow] + 1;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(countBits(32)));
        System.out.println(Arrays.toString(countBits2(32)));
    }

    private P_338() {}
}
