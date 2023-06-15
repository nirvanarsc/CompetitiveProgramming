package leetcode.weekly_contests.weekly_300_399.weekly_342;

public class P_1 {

    public int findDelayedArrivalTime(int arrivalTime, int delayedTime) {
        return (arrivalTime + delayedTime) % 24;
    }
}
