package weekly_contests.weekly_208;

public class P_1599 {

    public int minOperationsMaxProfit(int[] customers, int boardingCost, int runningCost) {
        int currIdx = 0;
        int currProfit = 0;
        int bestProfit = 0;
        int minRotations = -1;
        int waiting = 0;
        for (int i = 0; i < customers.length || waiting > 0; i++, currIdx = (currIdx + 1) % 4) {
            waiting += i < customers.length ? customers[i] : 0;
            final int boarding = Math.min(4, waiting);
            waiting -= boarding;
            currProfit += boarding * boardingCost - runningCost;
            if (currProfit > bestProfit) {
                bestProfit = currProfit;
                minRotations = i + 1;
            }
        }
        return minRotations;
    }
}
