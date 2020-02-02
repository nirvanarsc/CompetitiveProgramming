package medium;

public class P_1227 {

    public double nthPersonGetsNthSeatRecursive(int n) {
        if (n == 1) { return 1.0d; }
        return 1d / n + (n - 2d) / n * nthPersonGetsNthSeat(n - 1);
    }

    public double nthPersonGetsNthSeat(int n) {
        return n == 1 ? 1.0d : .5d;
    }
}
