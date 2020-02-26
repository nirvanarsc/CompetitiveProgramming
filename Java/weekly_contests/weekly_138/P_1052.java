package weekly_contests.weekly_138;

public class P_1052 {

    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int maxSum = 0, res = 0, sum = 0;
        for (int i = 0; i < grumpy.length; i++) {
            if (grumpy[i] == 0) {
                res += customers[i];
            } else {
                sum += customers[i];
            }
            if (i >= X && grumpy[i - X] == 1) {
                sum -= customers[i - X];
            }
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum + res;
    }
}

