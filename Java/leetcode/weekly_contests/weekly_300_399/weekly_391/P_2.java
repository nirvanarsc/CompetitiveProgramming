package leetcode.weekly_contests.weekly_300_399.weekly_391;

public class P_2 {

    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int res = 0;
        while (!(numBottles < numExchange)) {
            res += numExchange;
            numBottles -= numExchange++;
            numBottles++;
        }
        return res + numBottles;
    }
}
