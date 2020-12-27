package leetcode.biweekly_contests.biweekly_42;

public class P_1700 {

    public int countStudents(int[] students, int[] sandwiches) {
        int sq = 0;
        int ci = 0;
        for (int s : students) {
            if (s == 1) {
                sq++;
            } else {
                ci++;
            }
        }
        int res = -1;
        for (int i = 0; i < sandwiches.length; i++) {
            if (sandwiches[i] == 0) {
                if (ci == 0) {
                    res = i;
                    break;
                }
                ci--;
            } else {
                if (sq == 0) {
                    res = i;
                    break;
                }
                sq--;
            }
        }
        if (res == -1) {
            return 0;
        }
        return sandwiches.length - res;
    }
}
