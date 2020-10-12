package leetcode.weekly_contests.weekly_189;

public class P_1450 {

    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int res = 0;
        for (int i = 0; i < startTime.length; i++) {
            if (startTime[i] <= queryTime && queryTime <= endTime[i]) {
                res++;
            }
        }
        return res;
    }
}
