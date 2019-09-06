import java.util.stream.IntStream;

public class AddDigits {

    public static void main(String[] args) {
        IntStream.range(1, 1000).forEach(i -> System.out.println(i + "\t" + addDigits2(i)));
    }

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
