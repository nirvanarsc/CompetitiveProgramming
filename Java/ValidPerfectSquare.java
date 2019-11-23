public class ValidPerfectSquare {

    // O(log(num))
    public boolean newtonMethod(int num) {
        long x = num;
        while (x * x > num) {
            x = (x + num / x) >> 1;
        }
        return x * x == num;
    }

    // O(log(num))
    public boolean binarySearch(int num) {
        int low = 1, high = num;
        while (low <= high) {
            final long mid = (low + high) >>> 1;
            if (mid * mid == num) {
                return true;
            } else if (mid * mid < num) {
                low = (int) mid + 1;
            } else {
                high = (int) mid - 1;
            }
        }
        return false;
    }

    // O(sqrt(num))
    public boolean isPerfectSquare(int num) {
        int i = 1;
        while (num > 0) {
            num -= i;
            i += 2;
        }
        return num == 0;
    }

    // O(sqrt(num))
    public boolean isPerfectSquare2(int num) {
        for (int i = 1; i <= 46340; i++) {
            if (i * i == num) {
                return true;
            }
        }
        return false;
    }
}
