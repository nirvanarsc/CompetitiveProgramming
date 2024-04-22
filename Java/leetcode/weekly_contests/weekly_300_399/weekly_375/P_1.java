package leetcode.weekly_contests.weekly_300_399.weekly_375;

public class P_1 {

    public int countTestedDevices(int[] batteryPercentages) {
        int res = 0;
        for (int b : batteryPercentages) {
            if (b - res > 0) {
                res++;
            }
        }
        return res;
    }
}
