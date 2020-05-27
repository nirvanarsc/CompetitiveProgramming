public class AddDigits {

    public int addDigits(int num) {
        if (num < 10) {
            return num;
        }

        int res = 0;
        while (num > 0) {
            res += num % 10;
            num /= 10;
        }

        return addDigits(res);
    }

    // https://en.wikipedia.org/wiki/Digital_root
    public static int addDigits2(int num) {
        return 1 + ((num - 1) % 9);
    }
}
