public class AddDigits {

    @SuppressWarnings("TailRecursion")
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
    public int addDigitsDR(int num) {
        if (num == 0) { return 0; }
        if (num % 9 == 0) { return 9; }
        return num % 9;
    }
}
