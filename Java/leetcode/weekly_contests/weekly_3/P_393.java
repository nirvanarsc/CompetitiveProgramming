package leetcode.weekly_contests.weekly_3;

public class P_393 {

    public boolean validUtf8(int[] data) {
        for (int i = 0; i < data.length; i++) {
            final int curr = shift(data[i]);
            if ((curr >> 7) != 0) {
                if ((curr >> 5) == 0b110) {
                    if (i > data.length - 1
                        || (shift(data[i + 1]) >> 6 != 0b10)) {
                        return false;
                    }
                    i++;
                } else if ((curr >> 4) == 0b1110) {
                    if (i > data.length - 2
                        || (shift(data[i + 1]) >> 6 != 0b10)
                        || (shift(data[i + 2]) >> 6 != 0b10)) {
                        return false;
                    }
                    i += 2;
                } else if ((curr >> 3) == 0b11110) {
                    if (i > data.length - 3
                        || (shift(data[i + 1]) >> 6 != 0b10)
                        || (shift(data[i + 2]) >> 6 != 0b10)
                        || (shift(data[i + 3]) >> 6 != 0b10)) {
                        return false;
                    }
                    i += 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    private static int shift(int num) {
        return num & 0b11111111;
    }
}
