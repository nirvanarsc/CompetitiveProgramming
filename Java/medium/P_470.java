package medium;

import java.util.Random;

public class P_470 {

    public int rand7() {
        return new Random().nextInt(7);
    }

    public int rand10() {
        int res;
        do {
            res = 0;
            for (int i = 0; i < 4; i++) {
                res |= getBit() << i;
            }
        } while (res > 9);
        return res + 1;
    }

    private int getBit() {
        int res;
        do {
            res = rand7();
        } while (res == 7);
        return res % 2;
    }

    public int rand10Mult() {
        int res;
        do {
            res = 7 * (rand7() - 1) + (rand7() - 1);
        } while (res >= 40);
        return res % 10 + 1;
    }
}
