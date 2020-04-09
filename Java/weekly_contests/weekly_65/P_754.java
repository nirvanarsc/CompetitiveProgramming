package weekly_contests.weekly_65;

public class P_754 {

    public int reachNumber(int target) {
        final long lTarget = Math.abs(target);
        int step = 0;
        int sum = 0;
        while (sum < lTarget || (sum - lTarget) % 2 != 0) {
            step++;
            sum += step;
        }
        return step;
    }
}
