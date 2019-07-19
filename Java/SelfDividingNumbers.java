import java.util.ArrayList;
import java.util.List;

public final class SelfDividingNumbers {

    public static void main(String[] args) {
        System.out.println(selfDividingNumbers(1, 1000));
        System.out.println(selfDividingNumbers(10, 100));
    }

    private static boolean checkSelfDividing(int num) {
        for (int i = num; i > 0; i /= 10) {
            final int curr = i % 10;
            if (curr == 0 || num % curr != 0) {
                return false;
            }
        }
        return true;
    }

    private static List<Integer> selfDividingNumbers(int left, int right) {
        final List<Integer> res = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if (checkSelfDividing(i)) {
                res.add(i);
            }
        }
        return res;
    }
}
