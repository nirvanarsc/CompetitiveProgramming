package leetcode.easy;

public class P_367 {

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
        long lo = 1, hi = num;
        while (lo < hi) {
            final long mid = (lo + hi) >>> 1;
            if (mid * mid < num) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo * lo == num;
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
