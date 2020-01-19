package easy;

public class P_849 {

    public int maxDistToClosest(int[] seats) {
        int first = Integer.MAX_VALUE;
        int last = Integer.MIN_VALUE;
        int res = 0, distance = 1;
        for (int i = 0; i < seats.length; i++) {
            if (seats[i] == 1) {
                first = Math.min(i, first);
                last = Math.max(i, last);
                seats[i] = -1;
            } else {
                seats[i] = Integer.MAX_VALUE;
            }
        }
        for (int i = first + 1; i < seats.length; i++) {
            if (seats[i] == -1) {
                distance = 1;
            } else {
                seats[i] = distance++;
            }
        }
        distance = 1;
        for (int i = last - 1; i >= 0; i--) {
            if (seats[i] == -1) {
                distance = 1;
            } else {
                seats[i] = Math.min(seats[i], distance++);
            }
        }
        for (int seat : seats) {
            res = Math.max(res, seat);
        }
        return res;
    }
}
