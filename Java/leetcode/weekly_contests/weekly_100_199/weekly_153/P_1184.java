package leetcode.weekly_contests.weekly_100_199.weekly_153;

public class P_1184 {

    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        if (start > destination) {
            final int t = start;
            start = destination;
            destination = t;
        }
        int clockwise = 0, sum = 0;
        for (int i = 0; i < distance.length; i++) {
            if (i >= start && i < destination) {
                clockwise += distance[i];
            }
            sum += distance[i];
        }
        return Math.min(clockwise, sum - clockwise);
    }
}
