package weekly_contests.weekly_198;

public class P_1518 {

    public int numWaterBottles(int numBottles, int numExchange) {
        int res = numBottles;
        int empty = numBottles;
        while (empty >= numExchange) {
            final int curr = empty / numExchange;
            res += empty / numExchange;
            empty = (empty % numExchange) + curr;
        }
        return res;
    }
}
